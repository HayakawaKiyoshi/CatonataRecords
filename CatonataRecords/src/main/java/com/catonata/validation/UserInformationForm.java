package com.catonata.validation;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;
import com.catonata.validation.Group.ValidationGroups.addressFirst;
import com.catonata.validation.Group.ValidationGroups.addressSecond;
import com.catonata.validation.Group.ValidationGroups.ageFirst;
import com.catonata.validation.Group.ValidationGroups.ageSecond;
import com.catonata.validation.Group.ValidationGroups.ageThird;
import com.catonata.validation.Group.ValidationGroups.birthdayFirst;
import com.catonata.validation.Group.ValidationGroups.birthdaySecond;
import com.catonata.validation.Group.ValidationGroups.birthdayThird;
import com.catonata.validation.Group.ValidationGroups.emailFirst;
import com.catonata.validation.Group.ValidationGroups.emailSecond;
import com.catonata.validation.Group.ValidationGroups.emailThird;
import com.catonata.validation.Group.ValidationGroups.genderFirst;
import com.catonata.validation.Group.ValidationGroups.genderSecond;
import com.catonata.validation.Group.ValidationGroups.genderThird;
import com.catonata.validation.Group.ValidationGroups.nameFirst;
import com.catonata.validation.Group.ValidationGroups.nameSecond;
import com.catonata.validation.Group.ValidationGroups.passFirst;
import com.catonata.validation.Group.ValidationGroups.passSecond;
import com.catonata.validation.Group.ValidationGroups.passThird;

public class UserInformationForm {

//コミット確認
	private String id;
	@NotEmpty(groups=passFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=20 , groups=passSecond.class)
	@Pattern(regexp ="^[a-zA-Z0-9]+$", message="{0}は半角英数字で入力してください", groups=passThird.class)
	private String password;
	@NotEmpty(groups=nameFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=nameSecond.class)
	private String name;
	@NotEmpty(groups=ageFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=3 , groups=ageSecond.class)
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください" , groups=ageThird.class)
	private String age;
	@NotEmpty(groups=genderFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=1 , groups=genderSecond.class)
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください" , groups=genderThird.class)
	private String gender;
	@NotEmpty(groups=birthdayFirst.class)
	@Pattern(regexp="((19|[2-9][0-9])[0-9]{2})/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])"
	,message="生年月日はYYYY/MM/DDの形式で入力してください。", groups=birthdaySecond.class)
	@DateCheck(message="正しい日付を入力してください。" , groups=birthdayThird.class)
	private String birthday;
	@NotEmpty(groups=addressFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=addressSecond.class)
	private String address;
	@NotEmpty(groups=emailFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=50 , groups=emailSecond.class)
	@Email(message="メールアドレスが正しい形で入力されていません。" , groups=emailThird.class)
	private String email;

	private String authority;

	private String creditnumber;
	private String creditspan;
	private String security;


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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}






}
