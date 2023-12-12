package entity;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
public class Musicia_In_ConcertArea {

	
	private Integer concertId;
	private Date date;
	private Time startHour;
	private Time endHour;
	private String areaName;
	private String Artistid;
	public Musicia_In_ConcertArea(Integer concertId, Date date, Time startHour, Time endHour, String areaName,
			String artistid) {
		super();
		this.concertId = concertId;
		this.date = date;
		this.startHour = startHour;
		this.endHour = endHour;
		this.areaName = areaName;
		Artistid = artistid;
	}
	
	public Integer getConcertId() {
		return concertId;
	}
	public void setConcertId(Integer concertId) {
		this.concertId = concertId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getStartHour() {
		return startHour;
	}
	public void setStartHour(Time startHour) {
		this.startHour = startHour;
	}
	public Time getEndHour() {
		return endHour;
	}
	public void setEndHour(Time endHour) {
		this.endHour = endHour;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getArtistid() {
		return Artistid;
	}
	public void setArtistid(String artistid) {
		Artistid = artistid;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(concertId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musicia_In_ConcertArea other = (Musicia_In_ConcertArea) obj;
		return concertId == other.concertId;
	}

	@Override
	public String toString() {
		return "Musicia_In_ConcertArea [concertId=" + concertId + ", date=" + date + ", startHour=" + startHour
				+ ", endHour=" + endHour + ", areaName=" + areaName + ", Artistid=" + Artistid + "]";
	}
		
}