package entity;

import java.util.Objects;

public class Concert implements Comparable<Concert> {
	private Long concert_id;

	public Concert(Long concert_id) {
		super();
		this.concert_id = concert_id;
	}

	public Long getConcert_id() {
		return concert_id;
	}

	public void setConcert_id(Long concert_id) {
		this.concert_id = concert_id;
	}

	@Override
	public String toString() {
		return "Concert [concert_id=" + concert_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(concert_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concert other = (Concert) obj;
		return Objects.equals(concert_id, other.concert_id);
	}

	@Override
	public int compareTo(Concert o) {
		return this.concert_id.compareTo(o.getConcert_id());
	}
	

}
