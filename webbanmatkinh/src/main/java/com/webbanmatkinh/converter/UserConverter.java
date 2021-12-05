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
		result.setId(entity.getId());
		
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setFullName(entity.getFullName());
		result.setEmail(entity.getEmail());
		result.setPhone(entity.getPhone());
		result.setAddress(entity.getAddress());
		result.setStatus(entity.getStatus());
		
		RoleEntity role = roleRepository.findOne(entity.getRole().getId());
		result.setRoleCode(role.getCode());
		result.setRoleid(role.getId());
		
		return result;
	}
	
	// them moi
	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		result.setEmail(dto.getEmail());
		result.setPhone(dto.getPhone());
		result.setAddress(dto.getAddress());
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		return result;
	}
	
	// update 
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		// them id thi no moi ko bill null id.
		/*result.setId(dto.getId());*/
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
