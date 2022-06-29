package com.catonata.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;
import com.catonata.validation.Group.ValidationGroups.artistFirst;
import com.catonata.validation.Group.ValidationGroups.artistSecond;
import com.catonata.validation.Group.ValidationGroups.mediaFirst;
import com.catonata.validation.Group.ValidationGroups.mediaSecond;
import com.catonata.validation.Group.ValidationGroups.priceFirst;
import com.catonata.validation.Group.ValidationGroups.priceSecond;
import com.catonata.validation.Group.ValidationGroups.priceThird;
import com.catonata.validation.Group.ValidationGroups.pro_nameFirst;
import com.catonata.validation.Group.ValidationGroups.pro_nameSecond;
import com.catonata.validation.Group.ValidationGroups.release_dateFirst;
import com.catonata.validation.Group.ValidationGroups.release_dateSecond;
import com.catonata.validation.Group.ValidationGroups.release_dateThird;
import com.catonata.validation.Group.ValidationGroups.stockFirst;
import com.catonata.validation.Group.ValidationGroups.stockSecond;
import com.catonata.validation.Group.ValidationGroups.stockThird;

public class ProductForm {
	private String pro_id;

	@NotEmpty(groups=pro_nameFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=pro_nameSecond.class)
	private String pro_name;
	@NotEmpty(groups=artistFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=60 , groups=artistSecond.class)
	private String artist;
	@NotEmpty(groups=mediaFirst.class)
	@ByteCheck(charset="UTF-8",min=1, max=20 , groups=mediaSecond.class)
	private String media;
	@NotEmpty(groups=priceFirst.class)
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください" , groups=priceSecond.class)
	@ByteCheck(charset="UTF-8",min=1, max=10 , groups=priceThird.class)
	private String price;
	@NotEmpty(groups=release_dateFirst.class)
	@Pattern(regexp="((19|[2-9][0-9])[0-9]{2})/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])"
	,message="生年月日はYYYY/MM/DDの形式で入力してください。", groups=release_dateSecond.class)
	@DateCheck (groups=release_dateThird.class)
	private String release_date;

	private String label;

	private String sold;
	@NotEmpty(groups=stockFirst.class)
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください" , groups=stockSecond.class)
	@ByteCheck(charset="UTF-8",min=1, max=10 , groups=stockThird.class)
	private String stock;

	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getSold() {
		return sold;
	}
	public void setSold(String sold) {
		this.sold = sold;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}




}
