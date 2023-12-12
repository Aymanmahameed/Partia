package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import entity.Allowed_In_Area;
import entity.Concert_Area;
import entity.Consts;
import entity.DISTRICT;
import entity.Location;
import entity.Musicia_In_ConcertArea;
import entity.Participant;
import entity.Parties;
import entity.Consts.Manipulation;
import utils.Checker;

public class PartyLogic {
	private static PartyLogic instance;

	private PartyLogic() {
		Init();
	}

	public static PartyLogic getInstance() {
		if (instance == null)
			instance = new PartyLogic();
		return instance;
	}

	HashMap<Long, Parties> parties = new HashMap<Long, Parties>();
	HashMap<String, Location> locations = new HashMap<String, Location>();
	HashMap<Integer, Musicia_In_ConcertArea> shows = new HashMap<Integer, Musicia_In_ConcertArea>();

	public ArrayList<Parties> getParties() {
		ArrayList<Parties> res = new ArrayList<Parties>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PARTIES);

					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					Long PartyNum = rs.getLong(i++);
					String PartyName = rs.getString(i++);
					String Street = rs.getString(i++);
					Integer buldnum = rs.getInt(i++);
					String city = rs.getString(i++);
					DISTRICT d = DISTRICT.valueOf(rs.getString(i++));
					Date startdate = rs.getDate(i++);
					Date endtdate = rs.getDate(i++);
					String mid = rs.getString(i++);

					res.add(new Parties(PartyNum, PartyName, Street, buldnum, city, d, startdate, endtdate, mid));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("all");
		}
		return res;
	}

	public ArrayList<Musicia_In_ConcertArea> getShows() {
		ArrayList<Musicia_In_ConcertArea> res = new ArrayList<Musicia_In_ConcertArea>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_SHOW);

					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					String locName = rs.getString(i++);
					String musId = rs.getString(i++);
					Integer conId = rs.getInt(i++);
					Date date = rs.getDate(i++);
					Time sh = rs.getTime(i++);
					Time eh = rs.getTime(i++);

					res.add(new Musicia_In_ConcertArea(conId, date, sh, eh, locName, musId));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("all");
		}
		return res;
	}

	public ArrayList<Concert_Area> getConcerts() {
		ArrayList<Concert_Area> res = new ArrayList<Concert_Area>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_CONCERTS);

					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					String locName = rs.getString(i++);
					Double dailyprice = rs.getDouble(i++);
					Double size = rs.getDouble(i++);
					Integer maxtickets = rs.getInt(i++);
					Integer maxparticipant = rs.getInt(i++);
					String musicType = rs.getString(i++);
					Long partyNum = rs.getLong(i++);

					res.add(new Concert_Area(locName, dailyprice, size, maxtickets, maxparticipant, partyNum,
							musicType));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("all");
		}
		return res;
	}

	public ArrayList<Location> getLocation() {
		ArrayList<Location> res = new ArrayList<Location>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PARTIESLOCATIONS);

					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					String locName = rs.getString(i++);
					Double dailyprice = rs.getDouble(i++);
					Double size = rs.getDouble(i++);
					Integer maxtickets = rs.getInt(i++);
					Integer maxparticipant = rs.getInt(i++);
					Long partyNum = rs.getLong(i++);

					res.add(new Location(locName, dailyprice, size, maxtickets, maxparticipant, partyNum));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("all");
		}
		return res;
	}

	public ArrayList<Participant> getParticipants() {
		ArrayList<Participant> res = new ArrayList<Participant>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PARTICIPANTINPARTY);

					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					Long particiandId = rs.getLong(i++);
					Long PartyNumber = rs.getLong(i++);
					String phone = rs.getString(i++);
					Date sd = rs.getDate(i++);
					Date ed = rs.getDate(i++);
					Participant p = new Participant(particiandId, sd, ed, PartyNumber, phone);


					res.add(p);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("all");
		}
		return res;
	}

	public ArrayList<Allowed_In_Area> getAllowed_In_Area() {
		ArrayList<Allowed_In_Area> res = new ArrayList<Allowed_In_Area>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PARTICIPANTINLOCATION);

					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					String AreaName = rs.getString(i++);
					Long particiandId = rs.getLong(i++);

					Date sd = rs.getDate(i++);
					Date ed = rs.getDate(i++);

					res.add(new Allowed_In_Area(AreaName, particiandId, sd, ed));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("all");
		}
		return res;
	}

	public ArrayList<Musicia_In_ConcertArea> getPartyshow(String id) {

		ArrayList<Musicia_In_ConcertArea> res = new ArrayList<Musicia_In_ConcertArea>();
		ArrayList<Musicia_In_ConcertArea> show = getShows();
		if (Checker.getInstance().isNum(id)) {
			Long pid = Long.parseLong(id);
			for (Musicia_In_ConcertArea m : show) {
				if ((locations.get(m.getAreaName())).getPartyNum().equals(pid)) {
					res.add(m);
				}
			}

		}
		return res;
	}

	public void InsertToPartInParty(Long partyId, Long ParticipantId, String phone, Date sdate, Date edate) {
		int errors = 0;
		ArrayList<Participant> al = getParticipants();
		Participant p = new Participant(ParticipantId, sdate, edate, partyId, phone);
		if (!al.contains(p)) {
			
			if (!manipulatePartInParty(p, Manipulation.INSERT) && !manipulatePartInParty(p, Manipulation.UPDATE))
				errors++;
		}
		System.out.println((errors == 0) ? "Export Participant successfully!"
				: String.format("Participant exported with %d errors!", errors));

	}

	public boolean manipulatePartInParty(Participant p, Manipulation manipulation) {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn
							.prepareCall((manipulation.equals(Manipulation.UPDATE)) ? Consts.SQL_UPDATE_PARTINPARTY
									: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INSERT_PARTINPARTY
											: Consts.SQL_DEL_PARTINPARTY)) {
				allocatePartInPartysParams(stmt, p, manipulation);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			// e.printStackTrace();
		}

		return false;
	}

	private void allocatePartInPartysParams(CallableStatement stmt, Participant p, Manipulation m) throws SQLException {
		
		int i = 1;
		
		if (!m.equals(Manipulation.UPDATE)) {
			stmt.setLong(i++, p.getParticipantId());
			stmt.setLong(i++, p.getPartyId());
			stmt.setString(i++, p.getCustomerId());

			if (m.equals(Manipulation.DELETE))
				return;
		}
		

		if (p.getStartDate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setDate(i++, p.getStartDate());

		if (p.getEndDate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setDate(i++, p.getEndDate());

		if (m.equals(Manipulation.UPDATE)) {
			stmt.setLong(i++, p.getParticipantId());
			stmt.setLong(i++, p.getPartyId());
			stmt.setString(i++, p.getCustomerId());

		}

	}

	public void InsertToPartInLocation(String areaName, Long ParticipantId, Date sdate, Date edate) {
		int errors = 0;
		ArrayList<Allowed_In_Area> al = getAllowed_In_Area();
		Allowed_In_Area a = new Allowed_In_Area(areaName, ParticipantId, sdate, edate);
		if (!al.contains(a)) {
			
			if (!manipulatePartInLocation(a, Manipulation.INSERT) && !manipulatePartInLocation(a, Manipulation.UPDATE))
				errors++;
		}
		System.out.println((errors == 0) ? "Export Participant successfully!"
				: String.format("ParticipantInLocation exported with %d errors!", errors));

	}

	public boolean manipulatePartInLocation(Allowed_In_Area a, Manipulation manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn
							.prepareCall((manipulation.equals(Manipulation.UPDATE)) ? Consts.SQL_UPDATE_PARTINLOCATION
									: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INSERT_PARTINLOCATION
											: Consts.SQL_DEL_PARTINLOCATION)) {
				allocatePartInLocParams(stmt, a, manipulation);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			 //e.printStackTrace();
		}

		return false;
	}

	private void allocatePartInLocParams(CallableStatement stmt, Allowed_In_Area a, Manipulation m)
			throws SQLException {
		int i = 1;

		if (!m.equals(Manipulation.UPDATE)) {
			stmt.setString(i++, a.getAreaName());
			stmt.setLong(i++, a.getParticipantId());

			if (m.equals(Manipulation.DELETE))
				return;
		}

		if (a.getStartDate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setDate(i++, a.getStartDate());

		if (a.getEndDate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setDate(i++, a.getEndDate());

		if (m.equals(Manipulation.UPDATE)) {
			stmt.setString(i++, a.getAreaName());
			stmt.setLong(i++, a.getParticipantId());

		}

	}

	public Parties getPartyById(Long id) {

		return parties.get(id);
	}

	public Location getlocationById(String id) {
		return locations.get(id);
	}

	public Musicia_In_ConcertArea getshowById(Integer id) {
		return shows.get(id);
	}

	public Participant getlastParticipant() {
		ArrayList<Participant> ts = getParticipants();
		
		Participant maxp = null;
		Long max = ts.get(0).getParticipantId();
		
		for(int i=1;i<ts.size();i++) {
			if(ts.get(i).getParticipantId()>max) {
				max=ts.get(i).getParticipantId();
				maxp=ts.get(i);
			}
		}
		
		return maxp;
	}

	void Init() {
		ArrayList<Parties> par = getParties();
		ArrayList<Location> loc = getLocation();
		ArrayList<Musicia_In_ConcertArea> show = getShows();
		ArrayList<Concert_Area> concArea = getConcerts();
		for (Parties p : par) {
			parties.put(p.getPartyId(), p);
		}

		for (Location l : loc) {
			locations.put(l.getAreaName(), l);
		}

		for (Musicia_In_ConcertArea m : show) {
			shows.put(m.getConcertId(), m);
		}
		for (Concert_Area c : concArea) {
			locations.put(c.getAreaName(), c);
		}
	}

}
