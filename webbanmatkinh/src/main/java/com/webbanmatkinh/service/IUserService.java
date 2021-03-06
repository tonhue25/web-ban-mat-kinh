package com.webbanmatkinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.entity.UserEntity;

public interface IUserService {
	
	UserDTO insertByAdmin(UserDTO dto);
	
	UserDTO insert(UserDTO dto);

	UserEntity findOneByUserNameAndStatus(String username, int status);

	UserEntity findOne(Long id);

	List<UserEntity> findByRole(Long roleid);

	void deleteByRole(Long roleid);

	UserDTO update(UserDTO dto);

	void updatePassword(UserEntity user, String newPass);

	UserEntity get(String resetPasswordToken);

	void updateResetPassword(String token, String email) ;

	void delete(long[] ids);
	
	List<UserDTO> findAll(Pageable pageable);
	
	int getTotalItem();

	UserDTO updateByAdmin(UserDTO dto);
}
