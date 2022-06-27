package com.catonata.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.catonata.validation.ByteCheckValidation.ByteCheck;

public class ProductForm {
	private String pro_id;

	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String pro_name;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=60)
	private String artist;
	@NotEmpty
	@ByteCheck(charset="UTF-8",min=1, max=20)
	private String media;
	@NotEmpty
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください")
	@ByteCheck(charset="UTF-8",min=1, max=10)
	private String price;
	@NotEmpty
	private String release_date;

	private String label;

	private String sold;
	@NotEmpty
	@Pattern(regexp ="^[0-9]+$", message="{0}は半角数値で入力してください")
	@ByteCheck(charset="UTF-8",min=1, max=10)
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
