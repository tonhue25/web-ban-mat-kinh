package com.webbanmatkinh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanmatkinh.entity.CartEntity;
import com.webbanmatkinh.entity.ProductCartEntity;
import com.webbanmatkinh.entity.ProductEntity;

public interface ProductCartRepository extends JpaRepository<ProductCartEntity, Long> {
	ProductCartEntity findOneByProductAndCart(ProductEntity product, CartEntity cart);

	int countByCartAndStatus(CartEntity cart,String status);
	
	List<ProductCartEntity> findByCartAndStatus(CartEntity cart, String status);

	List<ProductCartEntity> findByProductAndCart(ProductEntity product, CartEntity cart);
	
	List<ProductCartEntity> findByCart(CartEntity cart);
	
	// tìm thử coi mã sản phẩm đó, có tồn tại trong giỏ hảng của ai đó không, nếu danh sách rỗng thì cho xóa.
	List<ProductCartEntity> findByProduct_id(Long id);
}
