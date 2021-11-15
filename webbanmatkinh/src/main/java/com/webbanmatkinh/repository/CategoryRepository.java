package com.webbanmatkinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanmatkinh.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
	CategoryEntity findOneByCode(String code);
	
}
