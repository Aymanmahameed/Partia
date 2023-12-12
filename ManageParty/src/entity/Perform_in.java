	package entity;

import java.util.Objects;

public class Perform_in {
	private Long concert_id;
	private Long musician_id;
	private Double price;
	public Perform_in(Long concert_id, Long musician_id, Double price) {
		super();
		this.concert_id = concert_id;
		this.musician_id = musician_id;
		this.price = price;
	}
	
	public Perform_in(Long concert_id, Long musician_id) {
		super();
		this.concert_id = concert_id;
		this.musician_id = musician_id;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Perform_in [concert_id=" + concert_id + ", musician_id=" + musician_id + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(concert_id, musician_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perform_in other = (Perform_in) obj;
		return Objects.equals(concert_id, other.concert_id) && Objects.equals(musician_id, other.musician_id);
	}
	
}
