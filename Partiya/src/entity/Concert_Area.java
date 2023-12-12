package entity;



public class Concert_Area extends Location {

	
	private String musicGenre;

	public Concert_Area(String areaName, double dailyTicketPrice, double areaSize, int maxTickets, int maxParticipants,
			String musicGenre) {
		super(areaName, dailyTicketPrice, areaSize, maxTickets, maxParticipants);
		this.musicGenre = musicGenre;
	}
	
	public Concert_Area(String areaName, Double dailyTicketPrice, Double areaSize, Integer maxTickets,
			Integer maxParticipants, Long PartyNum, String musicGenre) {
		super(areaName, dailyTicketPrice, areaSize, maxTickets, maxParticipants, PartyNum);
		this.musicGenre = musicGenre;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}

	@Override
	public String toString() {
		return "Concert_Area [areaName=" + areaName + ", dailyTicketPrice=" + dailyTicketPrice + ", areaSize="
				+ areaSize + ", maxTickets=" + maxTickets + ", maxParticipants=" + maxParticipants + ", PartyNum="
				+ PartyNum + ", musicGenre=" + musicGenre + "]";
	}
	
	

}