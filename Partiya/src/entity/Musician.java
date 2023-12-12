package entity;

import java.util.Objects;

public class Musician {

	private String Artistid;
	private String firstName;
	private String lastName;
	private Integer popularity;
	public Musician(String artistid, String firstName, String lastName, Integer popularity) {
		super();
		Artistid = artistid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.popularity = popularity;
	}
	public String getArtistid() {
		return Artistid;
	}
	public void setArtistid(String artistid) {
		Artistid = artistid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getPopularity() {
		return popularity;
	}
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Artistid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musician other = (Musician) obj;
		return Objects.equals(Artistid, other.Artistid);
	}
	@Override
	public String toString() {
		return "Musician [Artistid=" + Artistid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", popularity=" + popularity + "]";
	}
	

}