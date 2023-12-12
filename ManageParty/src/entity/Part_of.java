package entity;

import java.util.Objects;

public class Part_of {
	private Integer party_id;
	private String area_name;
	public Part_of(Integer party_id, String area_name) {
		super();
		this.party_id = party_id;
		this.area_name = area_name;
	}
	public Integer getParty_id() {
		return party_id;
	}
	public void setParty_id(Integer party_id) {
		this.party_id = party_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	@Override
	public String toString() {
		return "Part_of [party_id=" + party_id + ", area_name=" + area_name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(area_name, party_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part_of other = (Part_of) obj;
		return Objects.equals(area_name, other.area_name) && Objects.equals(party_id, other.party_id);
	}
	

}
