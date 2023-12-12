package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entity.Consts;
import entity.Musician;
import entity.Occurs_in;

public class MusicianLogic {
	private static MusicianLogic _instance;
	

	private MusicianLogic() {
		
	}

	public static MusicianLogic getInstance() {
		if (_instance == null)
			_instance = new MusicianLogic();
		return _instance;
	}
	
	public ArrayList<Musician> getMusicians(){
		ArrayList<Musician> results = new ArrayList<Musician>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_MUSICIANS);
					
					ResultSet rs = stmt.executeQuery())
			
			
			{
				
				while (rs.next()) {
					int i = 1;
					long id = rs.getLong(i++);
					String name = rs.getString(i++);
					Integer pop = rs.getInt(i++);
					
					results.add(new Musician(id, name, pop));
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
	
	public Musician isExis(String id) {
		ArrayList<Musician> al =getMusicians();
		for(int i =0;i<id.length();i++){
			if(id.charAt(i)<'0' || id.charAt(i)>'9')
				return null;
		}
		Musician m= new Musician(Long.parseLong(id));
		if(al.contains(m)) {
			int temp = al.indexOf(m);
			m=al.get(temp);
		}
		return m;
	}
	
	public ArrayList<Occurs_in> getPerMusicain(Musician m) {
		ArrayList<Occurs_in> al = OccursInLogic.getInstance().getOccursIn();
		ArrayList<Occurs_in> toRet = new ArrayList<Occurs_in>();
		for(Occurs_in o:al) {
			if(o.getMusician_id().equals(m.getMusician_id()))
				toRet.add(o);
				
		}
		return toRet;
	}
	

}
