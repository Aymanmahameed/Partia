package entity;

import java.sql.Date;
import java.util.Objects;
public class Allowed_In_Area {
	
	private String areaName;
	private Long participantId;
	private Date startDate;
	private Date endDate;
	
	public Allowed_In_Area(String areaName, Long participantId, Date startDate, Date endDate) {
		super();
		this.areaName = areaName;
		this.participantId = participantId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Allowed_In_Area(String areaName, Long participantId) {
		super();
		this.areaName = areaName;
		this.participantId = participantId;
	}

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Long getParticipantId() {
		return participantId;
	}
	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(areaName, participantId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Allowed_In_Area other = (Allowed_In_Area) obj;
		return Objects.equals(areaName, other.areaName) && participantId == other.participantId;
	}
	@Override
	public String toString() {
		return "Allowed_In_Area [areaName=" + areaName + ", participantId=" + participantId + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
	

}