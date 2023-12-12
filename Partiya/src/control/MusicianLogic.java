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

public class MusicianLogic {
	private static MusicianLogic instance;

	private MusicianLogic() {
		Init();
		
	}

	public static MusicianLogic getInstance() {
		if (instance == null)
			instance = new MusicianLogic();
		return instance;
	}
	
	HashMap<String, Musician> MusicianHash = new HashMap<String, Musician>();
	public ArrayList<Musician> getMusicians(){
		ArrayList<Musician> res = new ArrayList<Musician>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_ARTIST);

					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					String musID = rs.getString(i++);
					String fname = rs.getString(i++);
					String lname = rs.getString(i++);
					Integer pop = rs.getInt(i++);
					
					
			
					res.add(new Musician(musID, fname, lname, pop));
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
	public Musician getMusByid(String id) {
		
			return MusicianHash.get(id);
		
	}
	void Init() {
		ArrayList<Musician> al =getMusicians();
		for(Musician m:al) {
			MusicianHash.put(m.getArtistid(), m);
		}
	}
}
