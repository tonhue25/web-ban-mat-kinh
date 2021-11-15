package com.webbanmatkinh.service;

import java.util.HashMap;

import com.webbanmatkinh.dto.CartDTO;
import com.webbanmatkinh.entity.CartEntity;

public interface ICartService {

	HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart);

	HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart);

	HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart);

	/*int totalQuantity(HashMap<Long, CartDTO> cart);

	double totalPrice(HashMap<Long, CartDTO> cart);*/

	CartDTO insert(Long userid);
	
	void detete(Long cartid);
	
	CartEntity findOne(Long id);

	public Long getCartIdByUserId(Long userid);
}
