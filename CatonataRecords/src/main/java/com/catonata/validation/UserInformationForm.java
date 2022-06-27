package com.catonata.validation;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;

public class UserInformationForm {


	private String id;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=20)
	private String password;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String name;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=3)
	private String age;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=1)
	private String gender;
	@NotEmpty
	private String birthday;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String address;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=50)
	private String email;

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
