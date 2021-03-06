package com.webbanmatkinh.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanmatkinh.converter.CartConverter;
import com.webbanmatkinh.converter.ProductConverter;
import com.webbanmatkinh.dto.CartDTO;
import com.webbanmatkinh.dto.ProductDTO;
import com.webbanmatkinh.entity.CartEntity;
import com.webbanmatkinh.entity.ProductEntity;
import com.webbanmatkinh.repository.CartRepository;
import com.webbanmatkinh.repository.ProductRepository;
import com.webbanmatkinh.service.ICartService;

@Service
public class CartService implements ICartService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartConverter cartConverter;
	
	@Override
	public CartEntity findOne(Long id) {
		return cartRepository.findOne(id);
	}

	@Override
	public HashMap<Long,CartDTO> addCart(long id, HashMap<Long, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		ProductEntity productEntity = productRepository.findOne(id);
		ProductDTO productDTO = productConverter.toDto(productEntity);
		if(productDTO!=null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity()+1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getSalePrice());
		}
		else {
			itemCart.setProduct(productDTO);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(productDTO.getSalePrice());
		}
		cart.put(id,itemCart);
		return cart;
	}
	
	@Override
	public HashMap<Long,CartDTO> editCart(long id, int quantity,HashMap<Long, CartDTO> cart) {
		if(cart == null) {
			return cart;
		}
		CartDTO itemCart = new CartDTO();
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			double totalPrice = quantity * itemCart.getProduct().getSalePrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id,itemCart);
		return cart;
	}
	
	@Override
	public HashMap<Long,CartDTO> deleteCart(long id,HashMap<Long, CartDTO> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public CartEntity findOneByUserid(Long userid) {
		return cartRepository.findOneByUserid(userid);
	}

	@Override
	@Transactional
	public CartDTO insert(Long userid) {
		CartEntity cartEntity = cartConverter.toEntity(userid);
		cartEntity = cartRepository.save(cartEntity);
		return cartConverter.toDto(cartEntity);
	}
	
	@Override
	@Transactional
	public void detete(Long cartid) {
		cartRepository.delete(cartid);
	}
	
	@Override
	public Long getCartIdByUserId(Long userid) {
		Long cardid = (long)0;
		List<CartEntity> model = cartRepository.findAll();
		for(CartEntity item : model) {
			if(item.getUserid().getId() == userid) {
				cardid =  item.getId();
			}
		}
		return cardid;
	}
	
	// tinh tong tien ma no chua khuyen mai.
		// tinh tong tien da khuyen mai.
		// hieu => discount.
		// luu tax, shipping. => thong tin phai lay tu UI
}
