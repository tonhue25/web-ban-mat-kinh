package com.webbanmatkinh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanmatkinh.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long>{
	List<BillEntity> findByUser_id(Long userId);
}
