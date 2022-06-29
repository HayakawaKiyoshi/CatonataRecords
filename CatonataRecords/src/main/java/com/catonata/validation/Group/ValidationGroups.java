package com.catonata.validation.Group;

/**
 * validation用のグルーピングインタフェースが格納されているクラスです。
 * それぞれ変数名+順番名で記述されています。
 * 各クラスで順番を決めているので、追加する場合にはここにインタフェースを追加して
 * クラスも合わせて追加してください。
 *
 */
public class ValidationGroups {
	//UserInfomationForm
	public interface passFirst{}
	public interface passSecond{}
	public interface passThird{}
	public interface nameFirst{}
	public interface nameSecond{}
	public interface ageFirst{}
	public interface ageSecond{}
	public interface ageThird{}
	public interface genderFirst{}
	public interface genderSecond{}
	public interface genderThird{}
	public interface birthdayFirst{}
	public interface birthdaySecond{}
	public interface addressFirst{}
	public interface addressSecond{}
	public interface emailFirst{}
	public interface emailSecond{}
	public interface emailThird{}

	//ProductForm
	public interface pro_nameFirst{}
	public interface pro_nameSecond{}
	public interface artistFirst{}
	public interface artistSecond{}
	public interface mediaFirst{}
	public interface mediaSecond{}
	public interface priceFirst{}
	public interface priceSecond{}
	public interface priceThird{}
	public interface release_dateFirst{}
	public interface release_dateSecond{}
	public interface stockFirst{}
	public interface stockSecond{}
	public interface stockThird{}

	//LoginForm
	public interface idFirst{}

	//ExecInfomationForm
	public interface labelFirst{}
	public interface labelSecond{}
	public interface banknumberFirst{}
	public interface banknumberSecond{}
	public interface banknumberThird{}
	public interface banknameFirst{}
	public interface banknameSecond{}
	public interface banknameThird{}

	//DateCheckValidator
	public interface formatFirst{}
	public interface formatSecond{}

	//DateCheck


	//CreditCardInfomationForm
	public interface creditnumberFirst{}
	public interface creditnumberSecond{}
	public interface creditnumberThird{}
	public interface creditspanFirst{}
	public interface creditspanSecond{}
	public interface securityFirst{}
	public interface securitySecond{}
	public interface securityThird{}
}
