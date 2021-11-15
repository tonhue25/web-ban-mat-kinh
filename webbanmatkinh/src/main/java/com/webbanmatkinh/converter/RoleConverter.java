package com.webbanmatkinh.converter;

import org.springframework.stereotype.Component;

import com.webbanmatkinh.dto.RoleDTO;
import com.webbanmatkinh.entity.RoleEntity;

@Component
public class RoleConverter {
	
	public RoleDTO toDto(RoleEntity entities) {
		RoleDTO result = new RoleDTO();
		result.setId(entities.getId());
		result.setName(entities.getName());
		result.setCode(entities.getCode());
		return result;
	}
	
	public RoleEntity toEntity(RoleDTO dto) {
		RoleEntity result = new RoleEntity();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
	
	public RoleEntity toEntity(RoleEntity result,RoleDTO dto) {
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
}
