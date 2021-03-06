package com.webbanmatkinh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanmatkinh.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndStatus(String username, int status);

	List<UserEntity> findByRole(Long roleid);
	
	UserEntity findOneByEmail(String email);
	
	UserEntity findOneByResetPasswordToken(String resetPasswordToken);
}