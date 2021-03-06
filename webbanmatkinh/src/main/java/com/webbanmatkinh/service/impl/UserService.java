package com.webbanmatkinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.converter.UserConverter;
import com.webbanmatkinh.dto.CartDTO;
import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.entity.RoleEntity;
import com.webbanmatkinh.entity.UserEntity;
import com.webbanmatkinh.repository.UserRepository;
import com.webbanmatkinh.service.ICartService;
import com.webbanmatkinh.service.IRoleService;
import com.webbanmatkinh.service.IUserService;
@Service
public class UserService implements IUserService{

	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private ICartService cartService;
	
	@Override
	@Transactional
	public UserDTO insert(UserDTO dto) {
		UserEntity userEntity =  userConverter.toEntity(dto);
		dto.setRoleCode("USER");
		dto.setRoleid(SystemConstant.ROLE_USER);
		// chuyen ve dang BCryptPasswordEncoder roi moi luu xg db
		userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
		userEntity.setRole(roleService.findOne(SystemConstant.ROLE_USER));
		userEntity.setStatus(SystemConstant.ACTIVE_STATUS);
		userEntity = userRepository.save(userEntity);
		return userConverter.toDto(userEntity);
	}
	
	@Override
	@Transactional
	public UserDTO insertByAdmin(UserDTO dto) {
		UserEntity entity =  userConverter.toEntity(dto);
		
		entity.setPassword(passwordEncoder.encode(dto.getUserName()));
		entity.setRole(roleService.findOneByCode(dto.getRoleCode()));
		entity.setStatus(SystemConstant.ACTIVE_STATUS);
		
		entity = userRepository.save(entity);
		CartDTO c = cartService.insert(entity.getId());
		return userConverter.toDto(entity);
	}

	@Override
	@Transactional
	public UserDTO update(UserDTO dto) {
		UserEntity old = userRepository.findOne(dto.getId());
		UserEntity update = userConverter.toEntity(old,dto);
		return userConverter.toDto(userRepository.save(update));
	}

	@Override
	@Transactional
	public UserDTO updateByAdmin(UserDTO dto) {
		UserEntity old = userRepository.findOne(dto.getId());
		String pass =  userRepository.findOne(dto.getId()).getPassword();
		RoleEntity role = roleService.findOneByCode(dto.getRoleCode());
		UserEntity update = userConverter.toEntity(old,dto);
		update.setPassword(pass);
		update.setRole(role);
		return userConverter.toDto(userRepository.save(update));
	}
	
	@Override
	public UserEntity findOneByUserNameAndStatus(String username, int status) {
		return userRepository.findOneByUserNameAndStatus(username, status);
	}

	@Override
	public UserEntity findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<UserEntity> findByRole(Long roleid) {
		return userRepository.findByRole(roleid);
	}
	
	@Override
	public void deleteByRole(Long roleid) {
		List<UserEntity> entities = findByRole(roleid);
		for(UserEntity item : entities) {
			userRepository.delete(item);
		}
	}
	
	@Override
	public void updateResetPassword(String token,String email) {
		UserEntity userEntity = userRepository.findOneByEmail(email);
		if(userEntity!=null) {
			userEntity.setResetPasswordToken(token);
			userRepository.save(userEntity);
		}
	}
	
	@Override
	public UserEntity get(String resetPasswordToken) {
		return userRepository.findOneByResetPasswordToken(resetPasswordToken);
	}
	
	@Override
	public void updatePassword(UserEntity user,String newPass) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(newPass);
		user.setPassword(encodePassword);
		user.setResetPasswordToken(null);
		userRepository.save(user);
	}
	
	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id:ids) {
			UserEntity entity = userRepository.findOne(id);
			entity.setStatus(SystemConstant.INACTIVE_STATUS);
		}
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item : entities) {
			UserDTO dto = userConverter.toDto(item);
			models.add(dto);
		}
		return models;
	}
	
	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}
	
}
