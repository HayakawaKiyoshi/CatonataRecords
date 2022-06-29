package com.catonata.validation;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;
import com.catonata.validation.Group.ValidationGroups.addressFirst;
import com.catonata.validation.Group.ValidationGroups.addressSecond;
import com.catonata.validation.Group.ValidationGroups.banknameFirst;
import com.catonata.validation.Group.ValidationGroups.banknameSecond;
import com.catonata.validation.Group.ValidationGroups.banknameThird;
import com.catonata.validation.Group.ValidationGroups.banknumberFirst;
import com.catonata.validation.Group.ValidationGroups.banknumberSecond;
import com.catonata.validation.Group.ValidationGroups.banknumberThird;
import com.catonata.validation.Group.ValidationGroups.emailFirst;
import com.catonata.validation.Group.ValidationGroups.emailSecond;
import com.catonata.validation.Group.ValidationGroups.emailThird;
import com.catonata.validation.Group.ValidationGroups.labelFirst;
import com.catonata.validation.Group.ValidationGroups.labelSecond;
import com.catonata.validation.Group.ValidationGroups.nameFirst;
import com.catonata.validation.Group.ValidationGroups.nameSecond;
import com.catonata.validation.Group.ValidationGroups.passFirst;
import com.catonata.validation.Group.ValidationGroups.passSecond;
import com.catonata.validation.Group.ValidationGroups.passThird;

public class ExecInformationForm {
//テスト

	private String id;
	@NotEmpty(groups=nameFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=nameSecond.class)
	private String name;
	@NotEmpty(groups=passFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=20 , groups=passSecond.class)
	@Pattern(regexp ="^[a-zA-Z0-9]+$", message="{0}は半角英数字で入力してください" , groups=passThird.class)
	private String password;
	@NotEmpty(groups=labelFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=labelSecond.class)
	private String label;
	@NotEmpty(groups=emailFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=50 , groups=emailSecond.class)
	@Email (message="メールアドレスが正しい形で入力されていません。",groups=emailThird.class)
	private String email;
	@NotEmpty(groups=addressFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=addressSecond.class)
	private String address;
	@NotEmpty(groups=banknumberFirst.class)
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください" , groups=banknumberSecond.class)
	@ByteCheck(charset="UTF-8",min=7, max=8 , message = "{0}は7桁か8桁で入力してください。",groups=banknumberThird.class)
	private String banknumber;
	@NotEmpty(groups=banknameFirst.class)
	@Pattern(regexp ="[^ -~｡-ﾟ]+", message="{0}は全角文字で入力してください" , groups=banknameSecond.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=banknameThird.class)
	private String bankname;


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
