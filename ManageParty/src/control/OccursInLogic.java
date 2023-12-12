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



import entity.Consts;

import entity.Consts.Manipulation;
import entity.Occurs_in;

public class OccursInLogic {
	private static OccursInLogic _instance;

	private OccursInLogic() {

	}

	public static OccursInLogic getInstance() {
		if (_instance == null)
			_instance = new OccursInLogic();
		return _instance;
	}

	public ArrayList<Occurs_in> getOccursIn() {
		ArrayList<Occurs_in> results = new ArrayList<Occurs_in>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_OCCURIN);
					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					String areaName = rs.getString(i++);
					Long cid = rs.getLong(i++);
					Long mid = rs.getLong(i++);
					Date d = rs.getDate(i++);
					Time s = rs.getTime(i++);
					Time e = rs.getTime(i++);
					results.add(new Occurs_in(areaName, cid, mid, d, s, e));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("all");
		}
		return results;
	}
	
	public void InsertOccurIn(String areaName,Long concert_Id,Long musicianId,Date date,Time start,Time end) {

		ArrayList<Occurs_in> al = getOccursIn();
		int errors = 0;
		Occurs_in o = new Occurs_in(areaName, concert_Id, musicianId, date, start, end);
		if(!al.contains(o)) {
			if (!manipulateOccursIn(o, Manipulation.INSERT)&&
					!manipulateOccursIn(o, Manipulation.UPDATE))
				errors++;
			System.out.println((errors == 0) ? "Export data imported successfully!"
					: String.format("customers data imported with %d errors!", errors));
			
			
		}
		
		
	}
	
	public boolean manipulateOccursIn(Occurs_in o, Manipulation manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall((manipulation.equals(Manipulation.UPDATE))
							? Consts.SQL_UPDATE_OCCUR
							: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INSERT_OCCUR : Consts.SQL_DELETE_OCCUR)) {
				allocateOccrsInParams(stmt,o, manipulation);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
    			e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

  		e.printStackTrace();
		}

		return false;
	}
	
	private void allocateOccrsInParams(CallableStatement stmt, Occurs_in o, Manipulation m) throws SQLException  {
		int i = 1;

		if (!m.equals(Manipulation.UPDATE)) {
			stmt.setString(i++, o.getArea_name());
			stmt.setLong(i++, o.getConcert_id());
			stmt.setLong(i++, o.getMusician_id());

			if (m.equals(Manipulation.DELETE))
				return;
		}
		if (o.getDate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setDate(i++, o.getDate());
		
		if (o.getStart_our() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setTime(i++, o.getStart_our());
		
		if (o.getEnd_our() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setTime(i++, o.getEnd_our());

		

		if (m.equals(Manipulation.UPDATE)) {
			stmt.setString(i++, o.getArea_name());
			stmt.setLong(i++, o.getConcert_id());
			stmt.setLong(i++, o.getMusician_id());
		}

	}
	
	public boolean removeOccursIn(String AreaName,Long concert_id , Long musician_id) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt1 = conn.prepareCall(Consts.SQL_DELETE_OCCUR);) {
				stmt1.setString(1, AreaName);
				stmt1.setLong(2, concert_id);
				stmt1.setLong(3, musician_id);
				stmt1.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
