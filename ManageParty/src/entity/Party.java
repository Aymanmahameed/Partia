package entity;

import java.sql.Date;
import java.util.Objects;

public class Party {
	private Integer party_id;
	private String party_name;
	private String Street;
	private Integer building_number;
	private String city_code;
	private String city_name;
	private DISTRICT district;
	private Date StartingDate;
	private Date EndDate;
	public Party(Integer party_id, String party_name, String street, Integer building_number, String city_code,
			String city_name, DISTRICT district, Date startingDate, Date endDate) {
		super();
		this.party_id = party_id;
		this.party_name = party_name;
		Street = street;
		this.building_number = building_number;
		this.city_code = city_code;
		this.city_name = city_name;
		this.district = district;
		StartingDate = startingDate;
		EndDate = endDate;
	}
	public Integer getParty_id() {
		return party_id;
	}
	public void setParty_id(Integer party_id) {
		this.party_id = party_id;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public Integer getBuilding_number() {
		return building_number;
	}
	public void setBuilding_number(Integer building_number) {
		this.building_number = building_number;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public DISTRICT getDistrict() {
		return district;
	}
	public void setDistrict(DISTRICT district) {
		this.district = district;
	}
	public Date getStartingDate() {
		return StartingDate;
	}
	public void setStartingDate(Date startingDate) {
		StartingDate = startingDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	@Override
	public String toString() {
		return "Party [party_id=" + party_id + ", party_name=" + party_name + ", Street=" + Street
				+ ", building_number=" + building_number + ", city_code=" + city_code + ", city_name=" + city_name
				+ ", district=" + district + ", StartingDate=" + StartingDate + ", EndDate=" + EndDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(party_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Party other = (Party) obj;
		return Objects.equals(party_id, other.party_id);
	}
	
}
