package com.catonata.bean;

import java.io.Serializable;

public class ProductBean implements Serializable{

	private String pro_id;
	private String pro_name;
	private String artist;
	private String media;
	private String price;
	private String release_date;
	private String label;
	private String sold;
	private String stock;

	public ProductBean () {}	//デフォルトコンストラクタ
	public ProductBean(String pro_id,String pro_name,String artist,String media,
			String price, String release_date,String label,String stock) {
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.artist = artist;
		this.media = media;
		this.price = price;
		this.release_date = release_date;
		this.label = label;
		this.stock = stock;
	}
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
