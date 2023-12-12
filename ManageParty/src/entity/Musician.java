package entity;

import java.util.Objects;

public class Musician  {
	protected Long musician_id;
	protected String genre;
	protected Integer popularity;
	public Musician(Long musician_id, String genre, Integer popularity) {
		super();
		this.musician_id = musician_id;
		this.genre = genre;
		this.popularity = popularity;
	}
	
	public Musician(Long musician_id) {
		super();
		this.musician_id = musician_id;
	}

	public Long getMusician_id() {
		return musician_id;
	}
	public void setMusician_id(Long musician_id) {
		this.musician_id = musician_id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getPopularity() {
		return popularity;
	}
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	@Override
	public String toString() {
		return "Musician [musician_id=" + musician_id + ", genre=" + genre + ", popularity=" + popularity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(musician_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musician other = (Musician) obj;
		return Objects.equals(musician_id, other.musician_id);
	}
	
	

}
