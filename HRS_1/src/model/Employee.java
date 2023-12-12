package model;

import java.util.Objects;

import utils.Area;
import utils.Gender;

public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double salary;
	private Department department;
	private int startOfWork;
	private String username;
	private String password;

	public Employee(String id, String firstName, String lastName, String phoneNumber, Area area, Gender gender,
			int yearOfBirth, double salary, Department department, int startOfWork, String username, String password) {
		super(id, firstName, lastName, phoneNumber, area, gender, yearOfBirth);
		this.salary = salary;
		this.department = department;
		this.startOfWork = startOfWork;
		this.username = username;
		this.password = password;
	}

	public Employee(String id, String firstName, String lastName, String phoneNumber, Area area, Gender gender,
			int yearOfBirth, int startOfWork, double salary, Department department) {
		super(id, firstName, lastName, phoneNumber, area, gender, yearOfBirth);
		this.salary = salary;
		this.department = department;
		this.startOfWork = startOfWork;
		this.username = null;
		this.password = null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStartOfWork() {
		return startOfWork;
	}

	public void setStartOfWork(int startOfWork) {
		this.startOfWork = startOfWork;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id " + getId() + " salary=" + salary + ", department=" + department + ", startOfWork="
				+ startOfWork + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(department, salary, startOfWork);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& startOfWork == other.startOfWork;
	}

}
