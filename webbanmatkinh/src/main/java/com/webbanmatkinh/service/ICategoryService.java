package com.webbanmatkinh.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.webbanmatkinh.dto.CategoryDTO;
import com.webbanmatkinh.entity.CategoryEntity;

public interface ICategoryService {
	Map<String, String> findAll();

	List<CategoryDTO> findAll(Pageable pageable);

	int getTotalItem();

	CategoryDTO insert(CategoryDTO dto);

	CategoryDTO update(CategoryDTO dto);

	void delete(long[] ids);

	CategoryEntity findOneByCode(String code);

	CategoryEntity findOne(Long id);

}
