package com.webbanmatkinh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{
	
	@Column(name = "name" , columnDefinition = "NVARCHAR(100) NOT NULL")
	private String name;
	
	@Column(name = "code" , columnDefinition = "NVARCHAR(100) NOT NULL")
	private String code;

	@OneToMany(mappedBy = "category")
	private List<ProductEntity> products = new ArrayList<>();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
}
