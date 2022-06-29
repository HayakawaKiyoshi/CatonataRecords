package com.catonata.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;
import com.catonata.validation.Group.ValidationGroups.creditnumberFirst;
import com.catonata.validation.Group.ValidationGroups.creditnumberSecond;
import com.catonata.validation.Group.ValidationGroups.creditnumberThird;
import com.catonata.validation.Group.ValidationGroups.creditspanFirst;
import com.catonata.validation.Group.ValidationGroups.creditspanSecond;
import com.catonata.validation.Group.ValidationGroups.genderThird;
import com.catonata.validation.Group.ValidationGroups.securityFirst;
import com.catonata.validation.Group.ValidationGroups.securitySecond;

public class CreditCardInformationForm {

	@NotEmpty(groups=creditnumberFirst.class)
	@Pattern(regexp ="([0-9]{4})-([0-9]{4})-([0-9]{4})-([0-9]{4})",
				message="{0}は半角数値で入力してください" , groups=creditnumberSecond.class)
	@ByteCheck(charset="UTF-8",min=1, max=19 , groups=creditnumberThird.class)
	private String creditnumber;
	@NotEmpty(groups=creditspanFirst.class)
	@Pattern(regexp="([0-9]{4})/([0-9]{2})", message="有効期限はyyyy/MMの形式で入力してください。" , groups=creditspanSecond.class)
	private String creditspan;
	@NotEmpty(groups=securityFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=3 , groups=securitySecond.class)
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください" , groups=genderThird.class)
	private String security;

	public String getCreditnumber() {return creditnumber;}
	public void setCreditnumber(String creditnumber) {this.creditnumber = creditnumber;}
	public String getCreditspan() {return creditspan;}
	public void setCreditspan(String creditspan) {this.creditspan = creditspan;}
	public String getSecurity() {return security;}
	public void setSecurity(String security) {this.security = security;}
}
