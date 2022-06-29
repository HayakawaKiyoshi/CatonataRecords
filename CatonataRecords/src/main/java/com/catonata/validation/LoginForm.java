package com.catonata.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;
import com.catonata.validation.Group.ValidationGroups.idFirst;
import com.catonata.validation.Group.ValidationGroups.nameFirst;
import com.catonata.validation.Group.ValidationGroups.nameSecond;
import com.catonata.validation.Group.ValidationGroups.passFirst;
import com.catonata.validation.Group.ValidationGroups.passSecond;
import com.catonata.validation.Group.ValidationGroups.passThird;

public class LoginForm {
	@NotEmpty(groups=idFirst.class)
	private String id;
	@NotEmpty(groups=nameFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=nameSecond.class)
	private String name;
	@NotEmpty(groups=passFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=20 , groups=passSecond.class)
	@Pattern(regexp ="^[a-zA-Z0-9]+$", message="{0}は半角英数字で入力してください" , groups=passThird.class)
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}





}
