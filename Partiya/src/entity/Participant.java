package entity;
import java.sql.Date;
import java.util.Objects;
public class Participant {

	private Long participantId;
	private Date startDate;
	private Date endDate;
	private Long partyId;
	private String customerId;
	public Participant(Long participantId, Date startDate, Date endDate, Long partyId, String customerId) {
		super();
		this.participantId = participantId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.partyId = partyId;
		this.customerId = customerId;
	}
	
	public Participant(Long participantId) {
		super();
		this.participantId = participantId;
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
	public Long getPartyId() {
		return partyId;
	}
	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(participantId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		return participantId == other.participantId;
	}
	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", partyId=" + partyId + ", customerId=" + customerId + "]";
	}
	
	

}