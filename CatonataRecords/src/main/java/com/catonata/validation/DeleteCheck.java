package com.catonata.validation;

import org.hibernate.validator.constraints.NotEmpty;

public class DeleteCheck {
	@NotEmpty
	private String[] check;

	public String[] getCheck() {
		return check;
	}

	public void setCheck(String[] check) {
		this.check = check;
	}

}
