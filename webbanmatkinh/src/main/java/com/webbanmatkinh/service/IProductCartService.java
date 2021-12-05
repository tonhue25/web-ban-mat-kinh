package com.webbanmatkinh.service;

import java.util.HashMap;
import java.util.List;

import com.webbanmatkinh.dto.ProductCartDTO;
import com.webbanmatkinh.entity.CartEntity;
import com.webbanmatkinh.entity.ProductCartEntity;
import com.webbanmatkinh.entity.ProductEntity;

public interface IProductCartService {

	public HashMap<Long, ProductCartDTO> getCart(Long cartId);

	ProductCartDTO update(Long productId, Long cartId, int quantity,HashMap<Long, ProductCartDTO> cart);

	void delete(Long productId, Long cartId);

	double subTotalPrice(Long cartid);

	public HashMap<Long, ProductCartDTO> addCart(long id, HashMap<Long, ProductCartDTO> cart);

	public HashMap<Long, ProductCartDTO> editCart(long id, int quantity, HashMap<Long, ProductCartDTO> cart);

	public HashMap<Long, ProductCartDTO> deleteCart(long id, HashMap<Long, ProductCartDTO> cart);

	ProductCartEntity findOneByProductAndCart(ProductEntity product, CartEntity cart);

	int countByCart(CartEntity cart,String status);		

	List<ProductCartEntity> findByProductAndCart(ProductEntity product, CartEntity cart);

	ProductCartDTO insert(Long productId, Long cartId);

	ProductCartEntity findOne(Long id);

	List<ProductCartEntity> findByCartAndStatus(CartEntity cart, String status);

	int countByCartAndStatus(CartEntity cart, String status);

	List<ProductCartEntity> findByCart(CartEntity cart);

	double noPromotionPrice(Long cartid);
	
	void delete(Long cartId);

	List<ProductCartEntity> findByProduct_id(Long id);
}
