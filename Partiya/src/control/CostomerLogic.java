package control;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;


import entity.Consts;
import entity.Costumer;
import entity.GENDER;
import entity.Participant;



public class CostomerLogic {
	private static CostomerLogic _instance;
	ArrayList<Costumer> al ;

	private CostomerLogic() {
		al = getCustomers();
		
	}

	public static CostomerLogic getInstance() {
		if (_instance == null)
			_instance = new CostomerLogic();
		return _instance;
	}

	/**
	 * fetches all employees from DB file.
	 * @return ArrayList of employees.
	 */
	public ArrayList<Costumer> getCustomers() {
		ArrayList<Costumer> results = new ArrayList<Costumer>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_CUSTOMES);
					
					ResultSet rs = stmt.executeQuery())
			
			
			{
				
				while (rs.next()) {
					int i = 1;
					String id = rs.getString(i++);
					String fn = rs.getString(i++);
					String ln = rs.getString(i++);
					String phn = rs.getString(i++);
					String gender = rs.getString(i++);
					GENDER g;
					if(gender.equals("Male"))
						g=GENDER.MALE;
					else if(gender.equals("Female"))
						g=GENDER.FEMALE;
					else if(gender.equals("Not intersted to share"))
						g=GENDER.NOT_INTRESTED_TO_SHARE;
					else
						g= GENDER.OTHER;
					
					Double age = rs.getDouble(i++);
					Boolean vip = rs.getBoolean(i++);
					Date d = rs.getDate(i++);
					results.add(new Costumer(id, fn, ln, phn,g , age, vip, d));
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
	public Costumer findOneCostumer(String fristName,String lastName) {
		ArrayList<Costumer> allCostmuer = al;
		for(Costumer c:allCostmuer) {
			if(c.getFirstName().equals(fristName) && c.getLastName().equals(lastName))
				return c;
		}
		return null;
	}
	public ArrayList<Costumer> findCostumers(String Name){
		ArrayList<Costumer> toReturn = new ArrayList<Costumer>();
		ArrayList<Costumer> allCostumers = al;
		for(Costumer c:allCostumers) {
			if(c.getFirstName().equals(Name) || c.getLastName().equals(Name))
				toReturn.add(c);
		}
		return toReturn;
		
	}
	public Costumer IsExsit(String phone) {
		ArrayList<Costumer> al = getCustomers();
		Costumer c = new Costumer(phone);
		if (al.contains(c)) {
			int temp = al.indexOf(c);
			Costumer fullc = al.get(temp);
			return fullc;

		} else
			return null;
	}
	
	public ArrayList<Participant> getParticbantbyphone(String phone){
		ArrayList<Participant> al = PartyLogic.getInstance().getParticipants();
		ArrayList<Participant> toret = new ArrayList<Participant>();
		for(Participant p :al) {
			if(p.getCustomerId().equals(phone)) {
				toret.add(p);
			}
		}
		return toret;
	}
	
	
}
