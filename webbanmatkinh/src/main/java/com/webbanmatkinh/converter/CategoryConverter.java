package com.webbanmatkinh.converter;

import org.springframework.stereotype.Component;

import com.webbanmatkinh.dto.CategoryDTO;
import com.webbanmatkinh.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDto(CategoryEntity entities) {
		CategoryDTO result = new CategoryDTO();
		result.setId(entities.getId());
		result.setName(entities.getName());
		result.setCode(entities.getCode());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryEntity result,CategoryDTO dto) {
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
}
