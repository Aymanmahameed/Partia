package entity;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Occurs_in {
	private String area_name;
	private Long concert_id;
	private Long musician_id;
	private Date date;
	private Time start_our;
	private Time end_our;
	public Occurs_in(String area_name, Long concert_id, Long musician_id, Date date, Time start_our, Time end_our) {
		super();
		this.area_name = area_name;
		this.concert_id = concert_id;
		this.musician_id = musician_id;
		this.date = date;
		this.start_our = start_our;
		this.end_our = end_our;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public Long getConcert_id() {
		return concert_id;
	}
	public void setConcert_id(Long concert_id) {
		this.concert_id = concert_id;
	}
	public Long getMusician_id() {
		return musician_id;
	}
	public void setMusician_id(Long musician_id) {
		this.musician_id = musician_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getStart_our() {
		return start_our;
	}
	public void setStart_our(Time start_our) {
		this.start_our = start_our;
	}
	public Time getEnd_our() {
		return end_our;
	}
	public void setEnd_our(Time end_our) {
		this.end_our = end_our;
	}
	@Override
	public String toString() {
		return "Occurs_in [area_name=" + area_name + ", concert_id=" + concert_id + ", musician_id=" + musician_id
				+ ", date=" + date + ", start_our=" + start_our + ", end_our=" + end_our + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(area_name, concert_id, musician_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Occurs_in other = (Occurs_in) obj;
		return Objects.equals(area_name, other.area_name) && Objects.equals(concert_id, other.concert_id)
				&& Objects.equals(musician_id, other.musician_id);
	}
	
	
	
	

}
