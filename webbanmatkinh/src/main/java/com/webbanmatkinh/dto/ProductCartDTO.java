package com.webbanmatkinh.dto;

public class ProductCartDTO extends AbstractDTO<ProductCartDTO>{
	
	private ProductDTO product;
	private CartDTO cart;
	private int quantity;
	private double totalPrice;
	private String status;
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public CartDTO getCart() {
		return cart;
	}

	public void setCart(CartDTO cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public ProductCartDTO() {
		super();
	}

	public ProductCartDTO(ProductDTO product, CartDTO cart, int quantity,double totalPrice) {
		super();
		this.product = product;
		this.cart = cart;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public ProductCartDTO(ProductDTO product, CartDTO cart, int quantity) {
		super();
		this.product = product;
		this.cart = cart;
		this.quantity = quantity;
	}

	public ProductCartDTO(ProductDTO product, CartDTO cart) {
		super();
		this.product = product;
		this.cart = cart;
	}
	
}
