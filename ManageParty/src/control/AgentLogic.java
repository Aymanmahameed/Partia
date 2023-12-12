package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import entity.Agent;
import entity.Consts;
import entity.Musician;





public class AgentLogic {
	private static AgentLogic _instance;
	ArrayList<Agent> Agents ;

	private AgentLogic() {
		Agents = getAgents();
	}

	public static AgentLogic getInstance() {
		if (_instance == null)
			_instance = new AgentLogic();
		return _instance;
	}
	public ArrayList<Agent> getAgents() {
		ArrayList<Agent> results = new ArrayList<Agent>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_AGENTS);
					
					ResultSet rs = stmt.executeQuery())
			
			
			{
				
				while (rs.next()) {
					int i = 1;
					long id = rs.getLong(i++);
					String name = rs.getString(i++);
					String email = rs.getString(i++);
					
					results.add(new Agent(id, name, email));
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
	
	public ArrayList<Musician> getMusicains(Agent a){
		ArrayList<Musician> toReturn = new ArrayList<Musician>();
		
		
		
		
		
		return toReturn;
		
	}
	public Agent isExsit(String id) {
		for(int i = 0;i<id.length();i++) {
			if(id.charAt(i)<'0' || id.charAt(i)>'9')
				return null;
		}
		Agent a = new Agent(Long.parseLong(id));
		if(Agents.contains(a)) {
			 int temp=Agents.indexOf(a);
			 a = Agents.get(temp);
		}
		else
			a=null;
		return a;
		
	}

}
