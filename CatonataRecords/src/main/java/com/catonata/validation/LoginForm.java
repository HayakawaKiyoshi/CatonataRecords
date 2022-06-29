package com.catonata.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;

public class LoginForm {
	@NotEmpty
	private String id;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String name;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=20)
	@Pattern(regexp ="^[a-zA-Z0-9]+$", message="{0}は半角英数字で入力してください")
	private String password;

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





}
