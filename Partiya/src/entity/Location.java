package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Location {

	protected String areaName;
	protected Double dailyTicketPrice;
	protected Double areaSize;
	protected Integer maxTickets;
	protected Integer maxParticipants;
	protected Long PartyNum;

	
	public Location(String areaName, Double dailyTicketPrice, Double areaSize, Integer maxTickets, Integer maxParticipants) {
		super();
		this.areaName = areaName;
		this.dailyTicketPrice = dailyTicketPrice;
		this.areaSize = areaSize;
		this.maxTickets = maxTickets;
		this.maxParticipants = maxParticipants;
	}
	
	public Location(String areaName, Double dailyTicketPrice, Double areaSize, Integer maxTickets,
			Integer maxParticipants, Long PartyNum) {
		super();
		this.areaName = areaName;
		this.dailyTicketPrice = dailyTicketPrice;
		this.areaSize = areaSize;
		this.maxTickets = maxTickets;
		this.maxParticipants = maxParticipants;
		this.PartyNum = PartyNum;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Double getDailyTicketPrice() {
		return dailyTicketPrice;
	}

	public void setDailyTicketPrice(double dailyTicketPrice) {
		this.dailyTicketPrice = dailyTicketPrice;
	}

	public Double getAreaSize() {
		return areaSize;
	}

	public void setAreaSize(double areaSize) {
		this.areaSize = areaSize;
	}

	public Integer getMaxTickets() {
		return maxTickets;
	}

	public void setMaxTickets(int maxTickets) {
		this.maxTickets = maxTickets;
	}

	public Integer getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	
	public Long getPartyNum() {
		return PartyNum;
	}

	public void setPartyNum(Long PartyNum) {
		this.PartyNum = PartyNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(areaName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(areaName, other.areaName);
	}

	@Override
	public String toString() {
		return "Location [areaName=" + areaName + ", dailyTicketPrice=" + dailyTicketPrice + ", areaSize=" + areaSize
				+ ", maxTickets=" + maxTickets + ", maxParticipants=" + maxParticipants + "]";
	}

	//functions
	public ArrayList<Participant> getPresentParicipant() {
		// TODO - implement Area.getPresentParicipant
		throw new UnsupportedOperationException();
	}

	public ArrayList<Participant> getAllowedParticipant() {
		// TODO - implement Area.getAllowedParticipant
		throw new UnsupportedOperationException();
	}

}