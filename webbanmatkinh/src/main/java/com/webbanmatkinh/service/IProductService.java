package com.webbanmatkinh.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webbanmatkinh.dto.ProductDTO;
import com.webbanmatkinh.entity.ProductEntity;

public interface IProductService {

	List<ProductDTO> findAll(Pageable pageable);
	
	Page<ProductEntity> findAllProductEntity(Pageable pageable) ;

	int getTotalItem();

	ProductDTO insert(ProductDTO dto);

	ProductDTO update(ProductDTO dto);

	void delete(long[] ids);

	List<ProductDTO> findAll();

	String findCategoryCodeById(Long id);

	void deleteByCategory(Long categoryid);

	/*List<ProductDTO> findAllByCategory(Pageable pageable, Long categoryid);*/

	Page<ProductEntity> findByCategory_id(Long category_id, Pageable pageable);

	List<ProductEntity> findByCategory_id(Long category_id);

	List<ProductEntity> findByNewproduct(String newProduct);

	List<ProductEntity> findByHotproduct(String hotProduct);

	Page<ProductEntity> findByNewproduct(String newProduct, Pageable pageable);

	Page<ProductEntity> findByHotproduct(String hotProduct, Pageable pageable);

	List<ProductDTO> findAllByHotproduct(Pageable pageable, String hotProduct);

	List<ProductDTO> findAllByNewproduct(Pageable pageable, String newProduct);

	ProductEntity findOne(Long id);
	
	int countByHotproduct(String hotProduct);

	int countByNewproduct(String newProduct);

	int countByCategory_id(Long category_id);

	List<ProductDTO> findAllByHotproduct(String hotProduct);

	List<ProductDTO> findAllByNewproduct(String newProduct);

	Page<ProductEntity> findByNameContaining(String name, Pageable pageable);

	List<ProductEntity> findByNameContaining(String name);
}
