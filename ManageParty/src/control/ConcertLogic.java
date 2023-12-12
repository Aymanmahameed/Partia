package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.JFrame;
import entity.Concert;
import entity.Concert_Area;
import entity.Consts;
import entity.Musician;

import entity.Consts.Manipulation;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class ConcertLogic {
	
	private static ConcertLogic instance;
	
private ConcertLogic() {}
    
    /**
     * Singleton getter.
     * @return instance of this.
     */
    public static ConcertLogic getInstance() {
        if (instance == null)
            instance = new ConcertLogic();
        return instance;
    }
	
	public JFrame compileCustomerOrdersReport() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(Consts.CONN_STR)) {
            	JasperPrint print = JasperFillManager.fillReport(
            			getClass().getResourceAsStream("../boundary/MusicianReport.jasper"),
                        new HashMap<String, Object>(), conn);
                JFrame frame = new JFrame("Musician Concert Report");
                frame.getContentPane().add(new JRViewer(print));
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.pack();
                return frame;
            } catch (SQLException | JRException | NullPointerException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }
	
	public JFrame compileConcertsByLocationReport(Date date, Long Musicianid) {
		 try {
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(Consts.CONN_STR)) {
	            	HashMap<String, Object> params = new HashMap<>();
	            	params.put("d", date);
	            	params.put("id", Musicianid);
	            	
	            	JasperPrint print = JasperFillManager.fillReport(
	            			getClass().getResourceAsStream("../boundary/MusicianReport.jasper"),
	                        params, conn);
	            	
	                JFrame frame = new JFrame("Musician " + Musicianid + "'s Concerts by Location");
	                frame.getContentPane().add(new JRViewer(print));
	                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                frame.pack();
	                return frame;
	            } catch (SQLException | JRException | NullPointerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        
	        return null;
	}
	
	public TreeSet<Concert> getConcerts() {
		TreeSet<Concert> results = new TreeSet<Concert>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_CONCERTSID);
					
					ResultSet rs = stmt.executeQuery())
			
			
			{
				
				while (rs.next()) {
					int i = 1;
					Long id = rs.getLong(i++);
					Concert c = new Concert(id);
					System.out.println(c);
					results.add(c);
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
	
	public ArrayList<Concert_Area> getSameGenre(Musician m) {
		ArrayList<Concert_Area> al = new ArrayList<>();
		ArrayList<Concert_Area> al2=AreaLogic.getInstance().getConcert_Area();
		for(Concert_Area c :al2) {
			if(c.getGenre().equals(m.getGenre()))
				al.add(c);
		}
		return al;
	}
	
	public Long InsertConcert() {
		int errors = 0;
		TreeSet<Concert> ts = getConcerts();
		Concert c = new Concert(ts.last().getConcert_id()+1);
		ts.add(c);
		if (!manipulateConcert(c, Manipulation.INSERT)&&
				!manipulateConcert(c, Manipulation.UPDATE))
			errors++;
		System.out.println((errors == 0) ? "Export data imported successfully!"
				: String.format("customers data imported with %d errors!", errors));
		return ts.last().getConcert_id();
	}
	
	
	
	public boolean manipulateConcert(Concert c, Manipulation manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall((manipulation.equals(Manipulation.UPDATE))
							? Consts.SQL_UPDATE_CONCERTID
							: (manipulation.equals(Manipulation.INSERT)) ? Consts.SQL_INSERT_CONCERTID : Consts.SQL_DELETE_CONCERTID)) {
				allocateConcertsParams(stmt,c, manipulation);
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
	
	private void allocateConcertsParams(CallableStatement stmt, Concert c, Manipulation m) throws SQLException  {
		int i = 1;

		if (!m.equals(Manipulation.UPDATE)) {
			stmt.setLong(i++, c.getConcert_id());

			if (m.equals(Manipulation.DELETE))
				return;
		}
		

		

		if (m.equals(Manipulation.UPDATE))
			stmt.setLong(i++, c.getConcert_id());

	}
	
	public boolean removeConcertId(Long id) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt1 = conn.prepareCall(Consts.SQL_DELETE_CONCERTID);) {
				stmt1.setLong(1, id);
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
