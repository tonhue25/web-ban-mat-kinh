package com.webbanmatkinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webbanmatkinh.dto.CartDTO;
import com.webbanmatkinh.entity.CartEntity;
import com.webbanmatkinh.repository.UserRepository;

@Component
public class CartConverter {
	@Autowired
	private UserRepository userRepository;
	
	public CartDTO toDto(CartEntity entity) {
		CartDTO result = new CartDTO();
		result.setId(entity.getId());
		result.setUserId(entity.getUserid().getId());
		return result;
	}
	
	public CartEntity toEntity(Long userid) {
		CartEntity result = new CartEntity();
		result.setUserid(userRepository.findOne(userid));
		return result;
	}
	
}
