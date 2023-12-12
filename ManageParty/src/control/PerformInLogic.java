package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Consts;
import entity.Perform_in;
import entity.Consts.Manipulation;

public class PerformInLogic {
	private static PerformInLogic _instance;

	private PerformInLogic() {

	}

	public static PerformInLogic getInstance() {
		if (_instance == null)
			_instance = new PerformInLogic();
		return _instance;
	}
	
	public ArrayList<Perform_in> getPerfornIn() {
		ArrayList<Perform_in> results = new ArrayList<Perform_in>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PERFORMIN);
					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					Long Conid = rs.getLong(i++);
					Long musId = rs.getLong(i++);
					Double price = rs.getDouble(i++);
					
					results.add(new Perform_in(Conid, musId, price));
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
	public boolean InsertPerform(Long concert_Id,Long musicianId) {
		ArrayList<Perform_in> al = getPerfornIn();
		int errors = 0;
		Perform_in p = new Perform_in(concert_Id, musicianId);
		if(!al.contains(p)) {
			if (!manipulatePerformIn(p, Manipulation.INSERT)&&
					!manipulatePerformIn(p, Manipulation.UPDATE))
				errors++;
			System.out.println((errors == 0) ? "Export data imported successfully!"
					: String.format("customers data imported with %d errors!", errors));
			
			
		}
		return true;
		
	}
	
	public boolean manipulatePerformIn(Perform_in p, Manipulation manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall((manipulation.equals(Manipulation.UPDATE))
							? Consts.SQL_UPDATE_PERFORM
							: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INSERT_PERFORM : Consts.SQL_DELETE_PERFORM)) {
				allocatePerformInParams(stmt,p, manipulation);
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
	
	private void allocatePerformInParams(CallableStatement stmt, Perform_in p, Manipulation m) throws SQLException  {
		int i = 1;

		if (!m.equals(Manipulation.UPDATE)) {
			stmt.setLong(i++, p.getConcert_id());
			stmt.setLong(i++, p.getMusician_id());

			if (m.equals(Manipulation.DELETE))
				return;
		}
		if (p.getPrice() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setDouble(i++, p.getPrice());

		

		if (m.equals(Manipulation.UPDATE)) {
			stmt.setLong(i++, p.getConcert_id());
			stmt.setLong(i++, p.getMusician_id());
		}

	}
	
	public boolean removePerformIn(Long concert_id , Long musician_id) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt1 = conn.prepareCall(Consts.SQL_DELETE_PERFORM);) {
				stmt1.setLong(1, concert_id);
				stmt1.setLong(2, musician_id);
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
