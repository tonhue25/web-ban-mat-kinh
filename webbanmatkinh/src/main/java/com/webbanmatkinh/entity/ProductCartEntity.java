package com.webbanmatkinh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_cart")
public class ProductCartEntity extends BaseEntity {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private CartEntity cart;

	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductCartEntity(ProductEntity product, CartEntity cart, int quantity, String status) {
		super();
		this.product = product;
		this.cart = cart;
		this.quantity = quantity;
		this.status = status;
	}

	public ProductCartEntity() {
		super();
	}
	
}
