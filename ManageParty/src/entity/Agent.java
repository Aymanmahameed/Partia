package entity;

import java.util.Objects;

public class Agent {
	private Long agent_id;
	private String agent_name;
	private String e_mail;
	public Agent(Long agent_id, String agent_name, String e_mail) {
		super();
		this.agent_id = agent_id;
		this.agent_name = agent_name;
		this.e_mail = e_mail;
	}
	
	public Agent(Long agent_id) {
		super();
		this.agent_id = agent_id;
	}

	public Long getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(Long agent_id) {
		this.agent_id = agent_id;
	}
	public String getAgent_name() {
		return agent_name;
	}
	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	@Override
	public String toString() {
		return "Agent [agent_id=" + agent_id + ", agent_name=" + agent_name + ", e_mail=" + e_mail + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(agent_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		return Objects.equals(agent_id, other.agent_id);
	}
	
	

}
