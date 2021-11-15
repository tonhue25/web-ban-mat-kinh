package com.webbanmatkinh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "categorycode")
	private String categorycode;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategorycode() {
		return categorycode;
	}
	
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
}
