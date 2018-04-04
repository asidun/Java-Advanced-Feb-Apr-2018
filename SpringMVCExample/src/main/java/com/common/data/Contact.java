package com.common.data;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Contact {
	private int id;
	@NotEmpty
	@Size(min = 2, max = 30)
	private String firstName;
	@NotEmpty(message = "Fill the second name.")
	private String lastName;
	private Date birthDate;
	private int version;
	private List<ContactTelDetail> telDetails;
	private List<Hobby> hobbies;

	public List<ContactTelDetail> getTelDetails() {
		return telDetails;
	}

	public void setTelDetails(List<ContactTelDetail> telDetails) {
		this.telDetails = telDetails;
	}

	public List<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
