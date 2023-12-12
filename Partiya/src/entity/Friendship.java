package entity;

import java.util.Date;
import java.util.Objects;
public class Friendship {

	
	private String friendPhone1;
	private String friendPhone2;
	private Date startOfFriendship;
	public Friendship(String friendPhone1, String friendPhone2, Date startOfFriendship) {
		super();
		this.friendPhone1 = friendPhone1;
		this.friendPhone2 = friendPhone2;
		this.startOfFriendship = startOfFriendship;
	}
	
	public Friendship(String friendPhone1, String friendPhone2) {
		super();
		this.friendPhone1 = friendPhone1;
		this.friendPhone2 = friendPhone2;
	}

	public String getfriendPhone1() {
		return friendPhone1;
	}
	public void setfriendPhone1(String friendPhone1) {
		this.friendPhone1 = friendPhone1;
	}
	public String getfriendPhone2() {
		return friendPhone2;
	}
	public void setfriendPhone2(String friendPhone2) {
		this.friendPhone2 = friendPhone2;
	}
	public Date getStartOfFriendship() {
		return startOfFriendship;
	}
	public void setStartOfFriendship(Date startOfFriendship) {
		this.startOfFriendship = startOfFriendship;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(friendPhone1, friendPhone2);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friendship other = (Friendship) obj;
		return Objects.equals(friendPhone1, other.friendPhone1) && Objects.equals(friendPhone2, other.friendPhone2);
	}
	@Override
	public String toString() {
		return "Friendship [friendPhone1=" + friendPhone1 + ", friendPhone2=" + friendPhone2 + ", startOfFriendship="
				+ startOfFriendship + "]";
	}
	
	
	

}