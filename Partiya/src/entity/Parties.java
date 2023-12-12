package entity;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class Parties {

	
	private Long partyId;
	private String partyName;
	private String street;
	private Integer buildingNumber;
	private String city;
	private DISTRICT district;
	private Date startDate;
	private Date endDate;
	private String managerId;

	
	public Parties(Long partyId, String partyName, String street, Integer buildingNumber, String city, DISTRICT district,
			Date startDate, Date endDate, String managerId) {
		super();
		this.partyId = partyId;
		this.partyName = partyName;
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.district = district;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerId = managerId;
	}
	

	public Parties(Long partyId, String partyName, String street, Integer buildingNumber, String city, DISTRICT district,
			Date startDate, Date endDate) {
		super();
		this.partyId = partyId;
		this.partyName = partyName;
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.district = district;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public Long getPartyId() {
		return partyId;
	}


	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}


	public String getPartyName() {
		return partyName;
	}


	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public Integer getBuildingNumber() {
		return buildingNumber;
	}


	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public DISTRICT getDistrict() {
		return district;
	}


	public void setDistrict(DISTRICT district) {
		this.district = district;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getManagerId() {
		return managerId;
	}


	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(partyId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parties other = (Parties) obj;
		return partyId == other.partyId;
	}
	

	@Override
	public String toString() {
		return "Parties [partyId=" + partyId + ", partyName=" + partyName + ", street=" + street + ", buildingNumber="
				+ buildingNumber + ", city=" + city + ", district=" + district + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", managerId=" + managerId + "]";
	}


	//functions
	public ArrayList<Location> getAllAreas() {
		// TODO - implement Party.getAllAreas
		throw new UnsupportedOperationException();
	}

}