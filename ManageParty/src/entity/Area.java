package entity;

import java.util.Objects;

public class Area {
	protected String area_name;
	protected Integer daily_ticket_price;
	protected Double Size;
	protected Integer max_tickets;
	protected Integer max_particepnts;
	protected String manager_name;
	public Area(String area_name, Integer daily_ticket_price, Double size, Integer max_tickets, Integer max_particepnts,
			String manager_name) {
		super();
		this.area_name = area_name;
		this.daily_ticket_price = daily_ticket_price;
		Size = size;
		this.max_tickets = max_tickets;
		this.max_particepnts = max_particepnts;
		this.manager_name = manager_name;
	}
	public Area(String area_name, Integer daily_ticket_price, Double size, Integer max_tickets,
			Integer max_particepnts) {
		super();
		this.area_name = area_name;
		this.daily_ticket_price = daily_ticket_price;
		Size = size;
		this.max_tickets = max_tickets;
		this.max_particepnts = max_particepnts;
	}
	
	public Area(String area_name) {
		super();
		this.area_name = area_name;
	}
	
	public Area() {
		super();
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public Integer getDaily_ticket_price() {
		return daily_ticket_price;
	}
	public void setDaily_ticket_price(Integer daily_ticket_price) {
		this.daily_ticket_price = daily_ticket_price;
	}
	public Double getSize() {
		return Size;
	}
	public void setSize(Double size) {
		Size = size;
	}
	public Integer getMax_tickets() {
		return max_tickets;
	}
	public void setMax_tickets(Integer max_tickets) {
		this.max_tickets = max_tickets;
	}
	public Integer getMax_particepnts() {
		return max_particepnts;
	}
	public void setMax_particepnts(Integer max_particepnts) {
		this.max_particepnts = max_particepnts;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	@Override
	public String toString() {
		return "Area [area_name=" + area_name + ", daily_ticket_price=" + daily_ticket_price + ", Size=" + Size
				+ ", max_tickets=" + max_tickets + ", max_particepnts=" + max_particepnts + ", manager_name="
				+ manager_name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(area_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		return Objects.equals(area_name, other.area_name);
	}
	
}
