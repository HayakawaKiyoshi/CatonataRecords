package com.catonata.validation;

import org.hibernate.validator.constraints.NotEmpty;

public class UserInformationForm {

	@NotEmpty
	private String id;
	@NotEmpty
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String age;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String birthday;
	@NotEmpty
	private String address;
	@NotEmpty
	private String email;
	@NotEmpty
	private String authority;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}





}
