package entity;

public class Singer extends Musician {
	private String musician_first_name;
	private String musician_last_name;
	private String gender;
	public Singer(Long musician_id, String genre, Integer popularity, String musician_first_name,
			String musician_last_name, String gender) {
		super(musician_id, genre, popularity);
		this.musician_first_name = musician_first_name;
		this.musician_last_name = musician_last_name;
		this.gender = gender;
	}
	public String getMusician_first_name() {
		return musician_first_name;
	}
	public void setMusician_first_name(String musician_first_name) {
		this.musician_first_name = musician_first_name;
	}
	public String getMusician_last_name() {
		return musician_last_name;
	}
	public void setMusician_last_name(String musician_last_name) {
		this.musician_last_name = musician_last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Singer [musician_id=" + musician_id + ", genre=" + genre + ", popularity=" + popularity
				+ ", musician_first_name=" + musician_first_name + ", musician_last_name=" + musician_last_name
				+ ", gender=" + gender + "]";
	}
	
}
