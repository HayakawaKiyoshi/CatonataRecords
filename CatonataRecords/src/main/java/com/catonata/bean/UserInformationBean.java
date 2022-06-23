package com.catonata.bean;

import java.io.Serializable;

public class UserInformationBean implements Serializable{

	private String id;
	private String password;
	private String name;
	private String age;
	private String gender;
	private String birthday;
	private String address;
	private String email;
	private String authority;
	private String creditnumber;
	private String creditspan;
	private String securitycode;
	private String label;
	private String banknumber;
	private String bankname;

	public UserInformationBean () {
		//デフォルトコンストラクタ
	}
	public UserInformationBean(String id,String password,String name,
			String age,String gender,String birthday,String address,String email,
			String authority,String creditnumber,String cregitspan,
			String securitycode,String label,String banknumber,String bankname) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.authority = authority;
		this.creditnumber = creditnumber;
		this.creditspan = cregitspan;
		this.securitycode = securitycode;
		this.label = label;
		this.banknumber = banknumber;
		this.bankname = bankname;
	}
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
	public String getCreditnumber() {
		return creditnumber;
	}
	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}
	public String getCreditspan() {
		return creditspan;
	}
	public void setCreditspan(String creditspan) {
		this.creditspan = creditspan;
	}
	public String getSecuritycode() {
		return securitycode;
	}
	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getBanknumber() {
		return banknumber;
	}
	public void setBanknumber(String banknumber) {
		this.banknumber = banknumber;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}





}
