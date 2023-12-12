package entity;

import java.util.*;

public class Costumer {

	Collection<Friendship> friendship;
	private String customerId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private GENDER gender;
	private Double age;
	private Boolean isVIP;
	private Date dateOfRegistration;
	
	

	public Costumer(String customerId, String firstName, String lastName, String phoneNumber, GENDER gender, Double age,
			Boolean isVIP, Date dateOfRegistration) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.age = age;
		this.isVIP = isVIP;
		this.dateOfRegistration = dateOfRegistration;
	}


	public Costumer(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public GENDER getGender() {
		return gender;
	}



	public void setGender(GENDER gender) {
		this.gender = gender;
	}



	public Double getAge() {
		return age;
	}



	public void setAge(double age) {
		this.age = age;
	}



	public Boolean isVIP() {
		return isVIP;
	}



	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}



	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}



	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	
	






	@Override
	public int hashCode() {
		return Objects.hash(phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costumer other = (Costumer) obj;
		return Objects.equals(phoneNumber, other.phoneNumber);
	}







	@Override
	public String toString() {
		return "Costumer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", age=" + age + ", isVIP=" + isVIP
				+ ", dateOfRegistration=" + dateOfRegistration + "]";
	}
	
	//functions
	public Collection<Friendship> getFriendship() {
		return friendship;
	}



	public void setFriendship(Collection<Friendship> friendship) {
		this.friendship = friendship;
	}


	public boolean payToEvent() {
		// TODO - implement Costumer.payToEvent
		throw new UnsupportedOperationException();
	}

}