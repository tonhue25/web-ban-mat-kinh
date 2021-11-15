package com.webbanmatkinh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanmatkinh.converter.CategoryConverter;
import com.webbanmatkinh.dto.CategoryDTO;
import com.webbanmatkinh.entity.CategoryEntity;
import com.webbanmatkinh.repository.CategoryRepository;
import com.webbanmatkinh.service.ICategoryService;
import com.webbanmatkinh.service.IProductService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository  categoryRepository;
	
	@Autowired
	private CategoryConverter  categoryConverter;
	
	@Autowired
	private IProductService productService;
	
	@Override
	public int getTotalItem() {
		return (int) categoryRepository.count();
	}
	
	@Override
	public CategoryEntity findOneByCode(String code) {
		return categoryRepository.findOneByCode(code);
	}

	@Override
	public List<CategoryDTO> findAll(Pageable pageable){
		List<CategoryDTO> models= new ArrayList<>();
		List<CategoryEntity>entities =  categoryRepository.findAll(pageable).getContent();
		for(CategoryEntity item : entities) {
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			models.add(categoryDTO);
		}
		return models;
	}
	
	//
	@Override
	public Map<String,String> findAll() {
		Map<String,String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item:entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}
	
	@Override
	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		CategoryEntity categoryEntity = categoryConverter.toEntity(dto);
		categoryEntity = categoryRepository.save(categoryEntity);
		return categoryConverter.toDto(categoryEntity);
	}
	
	@Override
	@Transactional
	public CategoryDTO update(CategoryDTO dto) {
		CategoryEntity oldProduct = findOne(dto.getId());
		CategoryEntity updateProduct = categoryConverter.toEntity(oldProduct,dto);
		return categoryConverter.toDto(categoryRepository.save(oldProduct));
	}

	// trong ham nay, khi ma xoa 1 category trong list cac the loai nhap vao, 
	// thi can do tung san pham thuoc the loai do loi ra xoa truoc
	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id:ids) {
			productService.deleteByCategory(id);
			categoryRepository.delete(id);
		}
	}
	
	@Override
	public CategoryEntity findOne(Long id) {
		return categoryRepository.findOne(id);
	}
}
