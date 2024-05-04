package com.bookshopweb.beans;

public class CategoryBooks {
    private String categoryName;
    private Integer totalBooks;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getTotalBooks() {
		return totalBooks;
	}
	public void setTotalBooks(Integer totalBooks) {
		this.totalBooks = totalBooks;
	}
	@Override
	public String toString() {
	    return "{categoryName: '" + categoryName + "', totalBooks: " + totalBooks + "}";
	}

}
