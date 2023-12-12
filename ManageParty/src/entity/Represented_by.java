package entity;

import java.util.Objects;

public class Represented_by {
	private Long agent_id;
	private Long musician_id;
	private Double income_percentage;
	public Represented_by(Long agent_id, Long musician_id, Double income_percentage) {
		super();
		this.agent_id = agent_id;
		this.musician_id = musician_id;
		this.income_percentage = income_percentage;
	}
	public Long getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(Long agent_id) {
		this.agent_id = agent_id;
	}
	public Long getMusician_id() {
		return musician_id;
	}
	public void setMusician_id(Long musician_id) {
		this.musician_id = musician_id;
	}
	public Double getIncome_percentage() {
		return income_percentage;
	}
	public void setIncome_percentage(Double income_percentage) {
		this.income_percentage = income_percentage;
	}
	@Override
	public String toString() {
		return "Represented_by [agent_id=" + agent_id + ", musician_id=" + musician_id + ", income_percentage="
				+ income_percentage + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(agent_id, musician_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Represented_by other = (Represented_by) obj;
		return Objects.equals(agent_id, other.agent_id) && Objects.equals(musician_id, other.musician_id);
	}
	

}
