package com.pm.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String firstName;
	public String lastName;
	public String ssn;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, String ssn) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public Employee(String firstName, String lastName, String ssn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + "]";
	}

}
