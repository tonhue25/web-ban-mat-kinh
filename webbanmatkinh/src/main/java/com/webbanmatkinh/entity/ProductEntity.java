package com.webbanmatkinh.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{

	@Column(name = "name" , columnDefinition = "NVARCHAR(100) NOT NULL")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "hotproduct", columnDefinition = "NVARCHAR(50) NOT NULL")
	private String hotproduct;
	
	@Column(name = "newproduct" , columnDefinition = "NVARCHAR(50) NOT NULL")
	private String newproduct;
	
	@Column(name = "image" , columnDefinition = "NVARCHAR(50) NOT NULL")
	private String image;
	
	@Column(name = "sale")
	private double sale;
	
	@Column(name = "shortdescription", columnDefinition = "NVARCHAR(500) NOT NULL")
	private String shortDescription;

	@Column(name = "detail", columnDefinition = "NVARCHAR(500) NOT NULL")
	private String detail;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private Set<ProductCartEntity> productCart = new HashSet<>();
	
	public Set<ProductCartEntity> getProductCart() {
		return productCart;
	}

	public void setProductCart(Set<ProductCartEntity> productCart) {
		this.productCart = productCart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getHotProduct() {
		return hotproduct;
	}

	public void setHotProduct(String hotProduct) {
		this.hotproduct = hotProduct;
	}

	public String getNewProduct() {
		return newproduct;
	}

	public void setNewProduct(String newProduct) {
		this.newproduct = newProduct;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}


	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void addProductCart(ProductCartEntity productCartEntity) {
		this.productCart.add(productCartEntity);
	}
	
	public void removeProductCart(ProductCartEntity productCartEntity) {
		this.productCart.remove(productCartEntity);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getHotproduct() {
		return hotproduct;
	}

	public void setHotproduct(String hotproduct) {
		this.hotproduct = hotproduct;
	}

	public String getNewproduct() {
		return newproduct;
	}

	public void setNewproduct(String newproduct) {
		this.newproduct = newproduct;
	}

}
