package com.webbanmatkinh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanmatkinh.converter.RoleConverter;
import com.webbanmatkinh.dto.RoleDTO;
import com.webbanmatkinh.entity.RoleEntity;
import com.webbanmatkinh.repository.RoleRepository;
import com.webbanmatkinh.service.IRoleService;
import com.webbanmatkinh.service.IUserService;

@Service
public class RoleService implements IRoleService{
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public RoleEntity findOneByCode(String code) {
		return roleRepository.findOneByCode(code);
	}

	@Override
	@Transactional
	public RoleDTO insert(RoleDTO dto) {
		RoleEntity entity = roleConverter.toEntity(dto);
		entity = roleRepository.save(entity);
		return roleConverter.toDto(entity);
	}
	
	@Override
	@Transactional
	public RoleDTO update(RoleDTO dto) {
		RoleEntity old = findOne(dto.getId());
		RoleEntity update = roleConverter.toEntity(old,dto);
		return roleConverter.toDto(roleRepository.save(old));
	}
	
	// xoa vai tro nao thi can phai xoa người dùng đó trước đã.
	@Transactional
	public void delete(long[] ids) {
		for(long id:ids) {
			userService.deleteByRole(id);
			roleRepository.delete(id);
		}
	}
	
	@Override
	public RoleEntity findOne(Long id) {
		return roleRepository.findOne(id);
	}
	
	@Override
	public List<RoleDTO> findAll(Pageable pageable){
		List<RoleDTO> models= new ArrayList<>();
		List<RoleEntity>entities = roleRepository.findAll(pageable).getContent();
		for(RoleEntity item : entities) {
			RoleDTO dto = roleConverter.toDto(item);
			models.add(dto);
		}
		return models;
	}
	
	@Override
	public int getTotalItem() {
		return (int) roleRepository.count();
	}
	
	@Override
	public Map<String,String> findAll() {
		Map<String,String> result = new HashMap<>();
		List<RoleEntity> entities = roleRepository.findAll();
		for(RoleEntity item:entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}
}
