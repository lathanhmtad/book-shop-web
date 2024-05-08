package com.bookshopweb.beans;

public class CategorySalesReport {	
	private String categoryName;
	private Integer inventory;
	private Integer revenue;
	private Integer booksSold;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Integer getRevenue() {
		return revenue;
	}
	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}
	public Integer getBooksSold() {
		return booksSold;
	}
	public void setBooksSold(Integer booksSold) {
		this.booksSold = booksSold;
	}
	
	
}
