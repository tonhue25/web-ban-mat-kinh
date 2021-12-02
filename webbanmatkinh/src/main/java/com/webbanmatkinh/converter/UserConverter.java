package com.webbanmatkinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.entity.RoleEntity;
import com.webbanmatkinh.entity.UserEntity;
import com.webbanmatkinh.repository.RoleRepository;

@Component
public class UserConverter {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setFullName(entity.getFullName());
		result.setEmail(entity.getEmail());
		result.setPhone(entity.getPhone());
		result.setAddress(entity.getAddress());
		result.setStatus(entity.getStatus());
		result.setRoleid(entity.getRole().getId());
		
		return result;
	}

	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		RoleEntity role = roleRepository.findOne(SystemConstant.ROLE_USER);
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		result.setEmail(dto.getEmail());
		result.setPhone(dto.getPhone());
		result.setAddress(dto.getAddress());
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		result.setRole(role);
		return result;
	}
	
	public UserEntity toEntity(UserEntity result,UserDTO dto) {
		// them id thi no moi ko bill null id.
		result.setId(dto.getId());
		result.setPassword(dto.getPassword());
		result.setUserName(dto.getUserName());
		result.setFullName(dto.getFullName());
		result.setEmail(dto.getEmail());
		result.setPhone(dto.getPhone());
		result.setAddress(dto.getAddress());
		result.setStatus(dto.getStatus());
		result.setRole(roleRepository.findOne(dto.getRoleid()));
		return result;
	}
}