package com.catonata.bean;

public class PurchaseBean {

	private String id;
	private String pro_name;
	private String artist;
	private String price;
	private String label;
	private String purchase_date;
	private String delivery_date;

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getLabel() {return label;}
	public void setLabel(String label) {this.label = label;}
	public String getPurchase_date() {return purchase_date;}
	public void setPurchase_date(String purchase_date) {this.purchase_date = purchase_date;}
	public String getDelivery_date() {return delivery_date;}
	public void setDelivery_date(String delivery_date) {this.delivery_date = delivery_date;}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

}
