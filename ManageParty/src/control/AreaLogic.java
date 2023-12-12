package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Area;
import entity.Concert_Area;
import entity.Consts;

public class AreaLogic {
	private static AreaLogic instance;
	
	private AreaLogic() {}
	
	public static AreaLogic getInstance() {
        if (instance == null)
            instance = new AreaLogic();
        return instance;
    }
	ArrayList<Area> areas = getAreas();
	public ArrayList<Area> getAreas() {
		ArrayList<Area> results = new ArrayList<Area>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_AREAS);
					
					ResultSet rs = stmt.executeQuery())
			
			
			{
				
				while (rs.next()) {
					int i = 1;
					String areaName = rs.getString(i++);
					Integer dailyPrice = rs.getInt(i++);
					Double size = rs.getDouble(i++);
					Integer maxTickets= rs.getInt(i++);
					Integer maxParticipants = rs.getInt(i++);
					String ManagerName = rs.getString(i++);
					results.add(new Area(areaName, dailyPrice, size, maxTickets, maxParticipants,ManagerName));
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("all");
		}
		return results;
	}
	
	public ArrayList<Concert_Area> getConcert_Area() {
		ArrayList<Concert_Area> results = new ArrayList<Concert_Area>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_CONCERTS);
					
					ResultSet rs = stmt.executeQuery())
			
			
			{
				
				while (rs.next()) {
					int i = 1;
					String AreaName = rs.getString(i++);
					Area a = new Area(AreaName);
					if(areas.contains(a)) {
						int temp= areas.indexOf(a);
						a = areas.get(temp);
					}
					String genre = rs.getString(i++);
					results.add(new Concert_Area(a.getArea_name(), a.getDaily_ticket_price(), a.getSize(), a.getMax_tickets(), a.getMax_particepnts(), AreaName, genre));
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("all");
		}
		return results;
	}
}
