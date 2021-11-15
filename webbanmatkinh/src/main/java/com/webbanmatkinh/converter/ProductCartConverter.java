package com.webbanmatkinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webbanmatkinh.dto.ProductCartDTO;
import com.webbanmatkinh.entity.ProductCartEntity;

@Component
public class ProductCartConverter {
	
	@Autowired
	private CartConverter cartConverter;
	
	@Autowired
	private ProductConverter productConverter;
	
	public ProductCartDTO toDto(ProductCartEntity entity) {
		ProductCartDTO result = new ProductCartDTO();
		result.setId(entity.getId());
		result.setCart(cartConverter.toDto(entity.getCart()));
		result.setProduct(productConverter.toDto(entity.getProduct()));
		result.setQuantity(entity.getQuantity());
		result.setStatus(entity.getStatus());
		return result;
	}
	
	public ProductCartEntity toEntity(ProductCartDTO dto) {
		ProductCartEntity result = new ProductCartEntity();
		result.setCart(cartConverter.toEntity(dto.getCart().getUserId()));
		result.setProduct(productConverter.toEntity(dto.getProduct()));
		result.setQuantity(dto.getQuantity());
		result.setStatus(dto.getStatus());
		return result;
	}
	
	public ProductCartEntity toEntity(ProductCartEntity result,ProductCartDTO dto) {
		result.setCart(cartConverter.toEntity(dto.getCart().getUserId()));
		result.setProduct(productConverter.toEntity(dto.getProduct()));
		result.setQuantity(dto.getQuantity());
		result.setStatus(dto.getStatus());
		return result;
	}	
}
