package entity;

public class Concert_Area extends Area {
	private String genre;

	public Concert_Area(String area_name, Integer daily_ticket_price, Double size, Integer max_tickets,
			Integer max_particepnts, String manager_name, String genre) {
		super(area_name, daily_ticket_price, size, max_tickets, max_particepnts, manager_name);
		this.genre = genre;
	}

	public Concert_Area() {
		super();
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Concert_Area [area_name=" + area_name + ", Size=" + Size+ ", genre=" + genre + "]";
	}
	
	
}
