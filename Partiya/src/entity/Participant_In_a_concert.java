package entity;

import java.util.Objects;

public class Participant_In_a_concert {

	private int participantId;
	private int concertId;
	public Participant_In_a_concert(int participantId, int concertId) {
		super();
		this.participantId = participantId;
		this.concertId = concertId;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public int getConcertId() {
		return concertId;
	}
	public void setConcertId(int concertId) {
		this.concertId = concertId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(concertId, participantId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant_In_a_concert other = (Participant_In_a_concert) obj;
		return concertId == other.concertId && participantId == other.participantId;
	}
	@Override
	public String toString() {
		return "Participant_In_a_concert [participantId=" + participantId + ", concertId=" + concertId + "]";
	}
	
	

}