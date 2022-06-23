package com.catonata.validation;

import javax.validation.constraints.NotEmpty;

public class CreditCardInformationForm {

	@NotEmpty
	private String creditnumber;
	@NotEmpty
	private String creditspan;
	@NotEmpty
	private String security;

	public String getCreditnumber() {return creditnumber;}
	public void setCreditnumber(String creditnumber) {this.creditnumber = creditnumber;}
	public String getCreditspan() {return creditspan;}
	public void setCreditspan(String creditspan) {this.creditspan = creditspan;}
	public String getSecurity() {return security;}
	public void setSecurity(String security) {this.security = security;}

}
