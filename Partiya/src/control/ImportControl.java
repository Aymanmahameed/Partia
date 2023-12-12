package control;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.Parties;
import entity.Consts;
import entity.Consts.Manipulation;
import entity.DISTRICT;
import entity.Location;
import entity.Musician;
import entity.Participant;
import entity.Concert_Area;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ImportControl {
	private static ImportControl instance;

	private ImportControl() {
		
	}

	public static ImportControl getInstance() {
		if (instance == null)
			instance = new ImportControl();
		return instance;
	}

	public void importPartiesFromJSON(String path) {
		try (FileReader reader = new FileReader(new File(path))) {
			JsonObject doc = (JsonObject) Jsoner.deserialize(reader);
			JsonArray Parties = (JsonArray) doc.get("Parties_info");
			Iterator<Object> iterator = Parties.iterator();
			
			int errors = 0;
			while (iterator.hasNext()) {
				JsonObject obj = (JsonObject) iterator.next();
				Long pId = Long.parseLong((String) obj.get("partyId"));
				String pn = (String) obj.get("partyName");
				String st = (String) obj.get("street");
				int bn = Integer.parseInt((String) obj.get("buildingNumber"));
				String city = (String) obj.get("city");
				String district = (String) obj.get("district");
				DISTRICT d =DISTRICT.valueOf(district);
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				String sdateString = (String) obj.get("startDate");
				String edateString = (String) obj.get("endDate");// Replace with your string
				String manId = (String) obj.get("ManagerID");
				java.util.Date sutilDate;
				java.util.Date eutilDate;
				try {
					sutilDate = dateFormat.parse(sdateString);
					eutilDate = dateFormat.parse(edateString);
				} catch (ParseException e) {
					e.printStackTrace();
					return; // Handle the parse exception appropriately
				}
				Date sqlDate1 = new Date(sutilDate.getTime());
				Date sqlDate2 = new Date(eutilDate.getTime());

				Parties p = new Parties(pId, pn, st, bn, city, d, sqlDate1, sqlDate2,manId);
				if (!manipulateParty(p, Manipulation.INSERT) &&
						!manipulateParty(p, Manipulation.UPDATE))
					errors++;

				if (!((JsonArray) obj.get("Locations_info")).isEmpty()) {
					JsonArray locations = (JsonArray) obj.get("Locations_info");
					Iterator<Object> locationIterator = locations.iterator();
					while (locationIterator.hasNext()) {
						JsonObject locationObj = (JsonObject) locationIterator.next();

						// Extract area information
						String locationName = (String) locationObj.get("LocationName");
						Double ticketPrice = Double.parseDouble((String) locationObj.get("TicketPrice"));
						Double size = Double.parseDouble((String) locationObj.get("Size"));
						int maxTickets = Integer.parseInt((String) locationObj.get("MaxTickets"));
						int maxParticipant = Integer.parseInt((String) locationObj.get("MaxParticipant"));

						String musicType = (String) locationObj.getOrDefault("MusicType", "");
						Location l = null, s = null;

						if (musicType.equals("")) {
							l = new Location(locationName, ticketPrice, size, maxTickets, maxParticipant);
							if (!manipulateLocation(l, Manipulation.INSERT) && 
									!manipulateLocation(l, Manipulation.UPDATE))
								errors++;
						} else {
							s = new Concert_Area(locationName, ticketPrice, size, maxTickets, maxParticipant,
									 musicType);
							Concert_Area c = (Concert_Area) s;
							if (!manipulateLocation(c, Manipulation.INSERT) && 
									!manipulateLocation(c, Manipulation.UPDATE))
								errors++;

							JsonArray Atrists = (JsonArray) locationObj.get("Artist_info");
							Iterator<Object> ArtistIterator = Atrists.iterator();
							while (ArtistIterator.hasNext()) {
								JsonObject ArtistObj = (JsonObject) ArtistIterator.next();
								String id = (String) ArtistObj.get("ArtistID");
								String fname = (String) ArtistObj.get("FirstName");
								String lname = (String) ArtistObj.get("LastName");
								int pop = Integer.parseInt((String) ArtistObj.get("popularity"));
								Musician m = new Musician(id, fname, lname, pop);
							
								if (!manipulateArtist(m, Manipulation.INSERT)&&
										!manipulateArtist(m, Manipulation.UPDATE))
									errors++;

							}
						}
					}

				}
				
			}

			System.out.println((errors == 0) ? "Parties data imported successfully!"
					: String.format("customers data imported with %d errors!", errors));
			sendMessageToVipCostumer();
		} catch (IOException | DeserializationException e) {
			e.printStackTrace();
		}
	}

	public boolean manipulateParty(Parties P, Manipulation manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall((manipulation.equals(Manipulation.UPDATE))
							? Consts.SQL_UPDATE_PARTY
							: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INSERT_PARTY : Consts.SQL_DELETE_PARTY)) {
				allocatePartysParams(stmt, P, manipulation);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
    			//e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

  		//e.printStackTrace();
		}

		return false;
	}

	public boolean manipulateArtist(Musician M, Manipulation manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn
							.prepareCall((manipulation.equals(Manipulation.UPDATE))
									? Consts.SQL_UPDATE_ARTIST
											: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INS_ARTIST : Consts.SQL_DEL_ARTIST)) {
				allocateArtist(stmt, M, manipulation);
				
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
  			//e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

 		//e.printStackTrace();
		}

		return false;
	}

	private void allocateArtist(CallableStatement stmt, Musician musician, Manipulation m) throws SQLException {
		int i = 1;

		if (!m.equals(Manipulation.UPDATE)) {
			stmt.setString(i++, musician.getArtistid());

			if (m.equals(Manipulation.DELETE))
				return;
		}

		stmt.setString(i++, musician.getFirstName());
		stmt.setString(i++, musician.getLastName());
		if (musician.getPopularity() == null) {
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		} else
			stmt.setInt(i++, musician.getPopularity());

		if (m.equals(Manipulation.UPDATE))
			stmt.setString(i++, musician.getArtistid());

	}

	public boolean manipulateLocation(Location l, Manipulation manipulation) {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR)) {
				try {
					CallableStatement stmt = null;
					if (l instanceof Concert_Area) {
						stmt = conn
								.prepareCall((manipulation.equals(Manipulation.UPDATE))
										? Consts.SQL_UPDATE_CONCERT
												: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INSERT_CONCERT : Consts.SQL_DEL_CONCERT);
						Concert_Area c = (Concert_Area) l;
						allocateLocationParams(stmt, c, manipulation);
						
					} else if (l instanceof Location) {
						stmt = conn
								.prepareCall((manipulation.equals(Manipulation.UPDATE))
										? Consts.SQL_UPDATE_LOCATION
												: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INSERT_LOCATION : Consts.SQL_DEL_LOCATION);
						allocateLocationParams(stmt, l, manipulation);
						
					}	
					

						stmt.executeUpdate();

						return true;
					

				} catch (SQLException e) {
				 //e.printStackTrace();
				}

			} catch (SQLException e) {
				//e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}

		return false;
	}

	private void allocatePartysParams(CallableStatement stmt, Parties p, Manipulation m) throws SQLException {
		int i = 1;

		if (!m.equals(Manipulation.UPDATE)) {
			stmt.setLong(i++, p.getPartyId());

			if (m.equals(Manipulation.DELETE))
				return;
		}
		stmt.setString(i++, p.getPartyName());

		if (p.getStreet() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, p.getStreet());

		if (p.getBuildingNumber() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setInt(i++, p.getBuildingNumber());

		if (p.getCity() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, p.getCity());

		if (p.getDistrict() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, String.valueOf(p.getDistrict()));

		if (p.getStartDate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setDate(i++, p.getStartDate());

		if (p.getEndDate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setDate(i++, p.getEndDate());
		
		if(p.getManagerId()==null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, p.getManagerId());

		if (m.equals(Manipulation.UPDATE))
			stmt.setLong(i++, p.getPartyId());

	}

	private void allocateLocationParams(CallableStatement stmt, Location l, Manipulation m) throws SQLException {
		int i = 1;
		if (l instanceof Concert_Area) {
			Concert_Area c = (Concert_Area) l;
			if (!m.equals(Manipulation.UPDATE)) {
				stmt.setString(i++, l.getAreaName());

				if (m.equals(Manipulation.DELETE))
					return;
			}
			if (c.getDailyTicketPrice() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setDouble(i++, c.getDailyTicketPrice());
			if (c.getAreaSize() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setDouble(i++, l.getAreaSize());

			if (c.getMaxTickets() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setInt(i++, c.getMaxTickets());

			if (c.getMaxParticipants() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setInt(i++, c.getMaxParticipants());

			if (c.getMusicGenre() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setString(i++, c.getMusicGenre());

			if (c.getPartyNum() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setLong(i++, c.getPartyNum());

			if (m.equals(Manipulation.UPDATE))
				stmt.setString(i++, c.getAreaName());

		}

		else if (l instanceof Location) {
			if (!m.equals(Manipulation.UPDATE)) {
				stmt.setString(i++, l.getAreaName());

				if (m.equals(Manipulation.DELETE))
					return;
			}
			if (l.getDailyTicketPrice() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setDouble(i++, l.getDailyTicketPrice());
			if (l.getAreaSize() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setDouble(i++, l.getAreaSize());

			if (l.getMaxTickets() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setInt(i++, l.getMaxTickets());

			if (l.getMaxParticipants() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setInt(i++, l.getMaxParticipants());

			if (l.getPartyNum() == null)
				stmt.setNull(i++, java.sql.Types.VARCHAR);
			else
				stmt.setLong(i++, l.getPartyNum());

			if (m.equals(Manipulation.UPDATE))
				stmt.setString(i++, l.getAreaName());

		}

	}
	
	public void importCustomersFromXML(String path) {
    	try {
			Document doc = DocumentBuilderFactory.newInstance()
								.newDocumentBuilder().parse(new File(path));
			doc.getDocumentElement().normalize();
			NodeList nl = doc.getElementsByTagName("Participant");
			
			int errors = 0;
			for (int i = 0; i < nl.getLength(); i++) {
				if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element el = (Element) nl.item(i);
					Date sqlDatestart = null;
					Date sqlDateend = null;
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			        try {
			            java.util.Date parsedDate = dateFormat.parse(el.getElementsByTagName("StartDate").item(0).getTextContent());
			            java.util.Date parsedDate2 = dateFormat.parse(el.getElementsByTagName("EndDate").item(0).getTextContent());
			            // Convert java.util.Date to java.sql.Date
			             sqlDatestart = new Date(parsedDate.getTime());
			             sqlDateend = new Date(parsedDate2.getTime());
			            
			   
			        } catch (ParseException e) {
			            e.printStackTrace();
			        }
					Participant p = new Participant(Long.parseLong(el.getAttribute("ParticipantID")),
							sqlDatestart,
							sqlDateend,
							Long.parseLong(el.getElementsByTagName("PartyNum").item(0).getTextContent()),
							el.getElementsByTagName("PhoneNum").item(0).getTextContent()
							);
					
					if (!PartyLogic.getInstance().manipulatePartInParty(p, Manipulation.INSERT) && 
							!PartyLogic.getInstance().manipulatePartInParty(p, Manipulation.UPDATE))
						errors++;
				}
			}
			
			System.out.println((errors == 0) ? "Participant data imported successfully!" : 
				String.format("Participant data imported with %d errors!", errors));
			
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
    }
	 boolean sendMessageToVipCostumer() {
		 return true;
	 }

}
