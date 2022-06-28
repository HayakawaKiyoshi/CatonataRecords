package com.catonata.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;

public class ExecInformationForm {
//テスト

	private String id;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String name;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=20)
	@Pattern(regexp ="^[a-zA-Z0-9]+$", message="{0}は半角英数字で入力してください")
	private String password;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String label;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=50)
	private String email;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String address;
	@NotEmpty
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください")
	@ByteCheck(charset="UTF-8",min=1, max=8)
	private String banknumber;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String bankname;
//	@Pattern(regexp ="[^\\x01-\\x7E]", message="{0}は全角文字で入力してください")

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
