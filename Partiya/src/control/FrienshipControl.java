package control;

import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import entity.Consts;
import entity.Costumer;
import entity.Friendship;

public class FrienshipControl {
	private static FrienshipControl _instance;
	
	ArrayList<Costumer> alc;

	private FrienshipControl() {
		
		alc = CostomerLogic.getInstance().getCustomers();
	}

	public static FrienshipControl getInstance() {
		if (_instance == null)
			_instance = new FrienshipControl();
		return _instance;
	}

	public ArrayList<Friendship> getAllFriendships() {
		ArrayList<Friendship> results = new ArrayList<Friendship>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);

					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_ALLFREIENDSHIP);

					ResultSet rs = stmt.executeQuery())

			{

				while (rs.next()) {
					int i = 1;
					String phone1 = rs.getString(i++);
					String phone2 = rs.getString(i++);
					java.sql.Date d = rs.getDate(i++);
		
					results.add(new Friendship(phone1, phone2, d));
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

	public ArrayList<Costumer> getFriends(String customerphone) {
		ArrayList<Costumer> results = new ArrayList<Costumer>();
		ArrayList<Friendship> al = getAllFriendships();

		for (Friendship f : al) {
			if (f.getfriendPhone1().equals(customerphone)) {
				Costumer c = new Costumer(f.getfriendPhone2());
				int temp = alc.indexOf(c);
				if (temp != -1) {
					c = alc.get(temp);
					results.add(c);
				}
			}
		}
		return results;
	}

	public ArrayList<Costumer> getNotFriends(String customerphone) {
		ArrayList<Costumer> toRet = new ArrayList<Costumer>();
		ArrayList<Costumer> hisFriends = getFriends(customerphone);
		System.out.println(hisFriends);
		ArrayList<Costumer> allCustomees = CostomerLogic.getInstance().getCustomers();
		for (Costumer c : allCustomees) {
			if (!hisFriends.contains(c) && !(c.getPhoneNumber().equals(customerphone)))
				toRet.add(c);
		}
		return toRet;

	}

	public int exportNewFriendship(String customerphone1, String customerphone2) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_FREIENDSHIP)) {
				ArrayList<Friendship> al=getAllFriendships();
				al = getAllFriendships();
				if (al.contains(new Friendship(customerphone1, customerphone2)))
					return 2;

				int i = 1;
				stmt.setString(i++, customerphone1);
				stmt.setString(i++, customerphone2);
				stmt.executeUpdate();
				return 1;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int removeFriendship(String customerphone1, String customerphone2) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_FREIENDSHIP)) {
				ArrayList<Friendship> al=getAllFriendships();
				if (al.contains(new Friendship(customerphone1, customerphone2))) {
					stmt.setString(1, customerphone1);
					stmt.setString(2, customerphone2);
					stmt.executeUpdate();
					return 1;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;

	}
}
