package entity;

import java.util.Objects;

public class Manager {

	private String managerId;

	public Manager(String managerId) {
		super();
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Manager [id=" + managerId + "]";
	}

	public String getId() {
		return managerId;
	}

	public void setId(String id) {
		this.managerId = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(managerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(managerId, other.managerId);
	}
	
	

}