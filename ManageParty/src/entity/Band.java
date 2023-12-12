package entity;

public class Band extends Musician {
	private String Band_name;
	private Integer members_number;
	public Band(Long musician_id, String genre, Integer popularity, String band_name, Integer members_number) {
		super(musician_id, genre, popularity);
		Band_name = band_name;
		this.members_number = members_number;
	}
	public String getBand_name() {
		return Band_name;
	}
	public void setBand_name(String band_name) {
		Band_name = band_name;
	}
	public Integer getMembers_number() {
		return members_number;
	}
	public void setMembers_number(Integer members_number) {
		this.members_number = members_number;
	}
	@Override
	public String toString() {
		return "Band [musician_id=" + musician_id + ", genre=" + genre + ", popularity=" + popularity + ", Band_name="
				+ Band_name + ", members_number=" + members_number + "]";
	}
	

}
