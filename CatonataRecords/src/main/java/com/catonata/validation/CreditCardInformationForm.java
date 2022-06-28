package com.catonata.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;

public class CreditCardInformationForm {

	@NotEmpty
	@Pattern(regexp ="([0-9]{4})-([0-9]{4})-([0-9]{4})-([0-9]{4})",
				message="{0}は半角数値で入力してください")
	@ByteCheck(charset="UTF-8",min=1, max=19)
	private String creditnumber;
	@NotEmpty
	private String creditspan;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=3)
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください")
	private String security;

	public String getCreditnumber() {return creditnumber;}
	public void setCreditnumber(String creditnumber) {this.creditnumber = creditnumber;}
	public String getCreditspan() {return creditspan;}
	public void setCreditspan(String creditspan) {this.creditspan = creditspan;}
	public String getSecurity() {return security;}
	public void setSecurity(String security) {this.security = security;}
}
