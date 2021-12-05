package com.webbanmatkinh.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity{
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.MERGE)
    private Set<ProductCartEntity> productCart = new HashSet<>();
	
	@OneToOne
    @JoinColumn(name = "userid" , columnDefinition = "int NOT NULL")
    private UserEntity userid;
	
	public Set<ProductCartEntity> getProductCart() {
		return productCart;
	}

	public void setProductCart(Set<ProductCartEntity> productCart) {
		this.productCart = productCart;
	}

	public UserEntity getUserid() {
		return userid;
	}

	public void setUserid(UserEntity userid) {
		this.userid = userid;
	}
	
	public void addProductCart(ProductCartEntity productCartEntity) {
		this.productCart.add(productCartEntity);
	}
	
	public void removeProductCart(ProductCartEntity productCartEntity) {
		this.productCart.remove(productCartEntity);
	}
}
