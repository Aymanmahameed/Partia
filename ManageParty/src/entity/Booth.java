package entity;

import java.util.Objects;

public class Booth {
	private Integer booth_id;
	private BOOTHTYPE boothType;
	private PARTICIPANTTYPE participantType;
	private Boolean shade;
	private String area_name;
	public Booth(Integer booth_id, BOOTHTYPE boothType, PARTICIPANTTYPE participantType, Boolean shade,
			String area_name) {
		super();
		this.booth_id = booth_id;
		this.boothType = boothType;
		this.participantType = participantType;
		this.shade = shade;
		this.area_name = area_name;
	}
	public Booth(Integer booth_id, BOOTHTYPE boothType, PARTICIPANTTYPE participantType, Boolean shade) {
		super();
		this.booth_id = booth_id;
		this.boothType = boothType;
		this.participantType = participantType;
		this.shade = shade;
	}
	public Integer getBooth_id() {
		return booth_id;
	}
	public void setBooth_id(Integer booth_id) {
		this.booth_id = booth_id;
	}
	public BOOTHTYPE getBoothType() {
		return boothType;
	}
	public void setBoothType(BOOTHTYPE boothType) {
		this.boothType = boothType;
	}
	public PARTICIPANTTYPE getParticipantType() {
		return participantType;
	}
	public void setParticipantType(PARTICIPANTTYPE participantType) {
		this.participantType = participantType;
	}
	public Boolean getShade() {
		return shade;
	}
	public void setShade(Boolean shade) {
		this.shade = shade;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	@Override
	public String toString() {
		return "Booth [booth_id=" + booth_id + ", boothType=" + boothType + ", participantType=" + participantType
				+ ", shade=" + shade + ", area_name=" + area_name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(area_name, booth_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booth other = (Booth) obj;
		return Objects.equals(area_name, other.area_name) && Objects.equals(booth_id, other.booth_id);
	}
	
	
	
	
	

}
