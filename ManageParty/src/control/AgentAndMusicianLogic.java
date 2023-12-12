package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import entity.Consts;
import entity.Musician;
import entity.Represented_by;

public class AgentAndMusicianLogic {
private static AgentAndMusicianLogic _instance;
	HashMap<Long, ArrayList<Musician>> AgentAndMusician = new HashMap<Long, ArrayList<Musician>>();
	ArrayList<Represented_by> all ;
	

	private AgentAndMusicianLogic() {
		init_array();
		init_hash();
		
	}

	public static AgentAndMusicianLogic getInstance() {
		if (_instance == null)
			_instance = new AgentAndMusicianLogic();
		return _instance;
	}
	
	public void init_array() {
		ArrayList<Represented_by> results = new ArrayList<Represented_by>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_REPRESENTED);
					
					ResultSet rs = stmt.executeQuery())
			
			
			{
				
				while (rs.next()) {
					int i = 1;
					
					long agent_id = rs.getLong(i++);
					Long mus_id = rs.getLong(i++);
					Double income = rs.getDouble(i++);
					
					results.add(new Represented_by(agent_id, mus_id, income));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("all");
		}
		all = results;
		
	}
	public void init_hash() {
		ArrayList<Musician> allMusicians = MusicianLogic.getInstance().getMusicians();
		for(Represented_by r :all) {
			ArrayList<Musician> musician = AgentAndMusician.get(r.getAgent_id());
			if(musician==null)
				musician = new ArrayList<Musician>();
			Musician m =new Musician(r.getMusician_id());
			if(allMusicians.contains(m)) {
				int temp = allMusicians.indexOf(m);
				musician.add(allMusicians.get(temp));
			}
			AgentAndMusician.put(r.getAgent_id(), musician);
				
		}
		
	}
	
	public ArrayList<Musician> getMusicianbyAgent(Long id){
		return AgentAndMusician.get(id);
	}

}
