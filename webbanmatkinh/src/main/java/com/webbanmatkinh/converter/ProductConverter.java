package com.webbanmatkinh.converter;

import org.springframework.stereotype.Component;

import com.webbanmatkinh.dto.ProductDTO;
import com.webbanmatkinh.entity.ProductEntity;

// de nhung vao trang khac thi can dung annotation
@Component
public class ProductConverter {
	
	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO result = new ProductDTO();	
		result.setId(entity.getId());
		
		result.setName(entity.getName());
		result.setShortDescription(entity.getShortDescription());
		result.setDetail(entity.getDetail());
		result.setPrice(entity.getPrice());
		result.setHotProduct(entity.getHotProduct());
		result.setNewProduct(entity.getNewProduct());
		result.setSale(entity.getSale());
		result.setImage(entity.getImage());
		
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	// moi hoan toan
	public ProductEntity toEntity(ProductDTO dto) {
		
		ProductEntity result = new ProductEntity();
		result.setName(dto.getName());
		result.setShortDescription(dto.getShortDescription());
		result.setDetail(dto.getDetail());
		result.setPrice(dto.getPrice());
		result.setHotProduct(dto.getHotProduct());
		result.setNewProduct(dto.getNewProduct());
		result.setSale(dto.getSale());
		result.setImage(dto.getImage());
		return result;
	}
	
	// sua
	public ProductEntity toEntity(ProductEntity result,ProductDTO dto) {
		result.setName(dto.getName());
		result.setShortDescription(dto.getShortDescription());		
		result.setDetail(dto.getDetail());
		result.setPrice(dto.getPrice());
		result.setHotProduct(dto.getHotProduct());
		result.setNewProduct(dto.getNewProduct());
		result.setSale(dto.getSale());
		result.setImage(dto.getImage());
		return result;
	}
}
