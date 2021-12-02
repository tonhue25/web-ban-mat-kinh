package com.webbanmatkinh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.converter.UserConverter;
import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.entity.UserEntity;
import com.webbanmatkinh.repository.UserRepository;
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
	@Override
	@Transactional
	public UserDTO insert(UserDTO dto) {
		UserEntity userEntity =  userConverter.toEntity(dto);
		// chuyen ve dang BCryptPasswordEncoder roi moi luu xg db
		userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
		userEntity.setRole(roleService.findOne(SystemConstant.ROLE_USER));
		userEntity.setStatus(SystemConstant.ACTIVE_STATUS);
		userEntity = userRepository.save(userEntity);
		return userConverter.toDto(userEntity);
	}

	@Override
	@Transactional
	public UserDTO update(UserDTO dto) {
		UserEntity old = userRepository.findOne(dto.getId());
		UserEntity update = userConverter.toEntity(old,dto);
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
		}/*else {
			throw new CustomerNotFoundException("Could not found any customer with email!!"+email);
		}*/
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
	
}
