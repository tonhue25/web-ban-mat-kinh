package com.webbanmatkinh.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanmatkinh.entity.ProductEntity;

// ghi theo ten trong db
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	List<ProductEntity> findByCategory_id(Long category_id);
	List<ProductEntity> findByHotproduct(String hotProduct);
	List<ProductEntity> findByNewproduct(String newProduct);
	
	Page<ProductEntity> findByCategory_id(Long category_id,Pageable pageable);
	Page<ProductEntity> findByHotproduct(String hotProduct,Pageable pageable);
	Page<ProductEntity> findByNewproduct(String newProduct,Pageable pageable);
	
	int countByNewproduct(String newProduct);
	int countByHotproduct(String hotProduct);
	int countByCategory_id(Long category_id);
	
	List<ProductEntity> findByNameLike(String name);
	Page<ProductEntity> findByNameLike(String name,Pageable pageable);
	int countByNameLike(String name);
}
