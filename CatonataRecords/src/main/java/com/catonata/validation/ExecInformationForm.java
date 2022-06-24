package com.catonata.validation;

import org.hibernate.validator.constraints.NotEmpty;

public class ExecInformationForm {
//テスト
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	@NotEmpty
	private String label;
	@NotEmpty
	private String email;
	@NotEmpty
	private String address;
	@NotEmpty
	private String banknumber;
	@NotEmpty
	private String bankname;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

}
