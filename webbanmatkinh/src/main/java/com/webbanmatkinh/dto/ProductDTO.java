package com.webbanmatkinh.dto;

public class ProductDTO extends AbstractDTO<ProductDTO> {
	private String name;
	private String shortDescription;
	private String detail;
	private long categoryId;
	private String categoryCode;
	private double price;
	private String hotProduct;
	private String newProduct;
	private double sale;
	private String image;
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getHotProduct() {
		return hotProduct;
	}

	public void setHotProduct(String hotProduct) {
		this.hotProduct = hotProduct;
	}

	public String getNewProduct() {
		return newProduct;
	}

	public void setNewProduct(String newProduct) {
		this.newProduct = newProduct;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public double getSalePrice() {
		return (this.price - price * (sale / 100));
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
