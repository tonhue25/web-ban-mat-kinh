package com.webbanmatkinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanmatkinh.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{
	CartEntity findOneByUserid(Long userid);
}
