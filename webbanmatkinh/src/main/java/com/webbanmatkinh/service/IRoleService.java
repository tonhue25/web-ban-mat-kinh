package com.webbanmatkinh.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.webbanmatkinh.dto.RoleDTO;
import com.webbanmatkinh.entity.RoleEntity;

public interface IRoleService {

	RoleEntity findOne(Long id);

	RoleDTO update(RoleDTO dto);

	RoleDTO insert(RoleDTO dto);

	List<RoleDTO> findAll(Pageable pageable);

	int getTotalItem();
	
	Map<String, String> findAll();

	RoleEntity findOneByCode(String code);
}
