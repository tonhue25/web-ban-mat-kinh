package com.webbanmatkinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanmatkinh.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findOneByCode(String code);
}
