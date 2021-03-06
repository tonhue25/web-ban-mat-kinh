package com.webbanmatkinh.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.converter.CartConverter;
import com.webbanmatkinh.converter.ProductCartConverter;
import com.webbanmatkinh.converter.ProductConverter;
import com.webbanmatkinh.dto.CartDTO;
import com.webbanmatkinh.dto.ProductCartDTO;
import com.webbanmatkinh.dto.ProductDTO;
import com.webbanmatkinh.entity.CartEntity;
import com.webbanmatkinh.entity.ProductCartEntity;
import com.webbanmatkinh.entity.ProductEntity;
import com.webbanmatkinh.repository.CartRepository;
import com.webbanmatkinh.repository.ProductCartRepository;
import com.webbanmatkinh.repository.ProductRepository;
import com.webbanmatkinh.service.ICartService;
import com.webbanmatkinh.service.IProductCartService;
import com.webbanmatkinh.service.IProductService;
import com.webbanmatkinh.service.IUserService;
import com.webbanmatkinh.util.SecurityUtils;

@Service
public class ProductCartService implements IProductCartService {

	@Autowired
	private ProductCartRepository productCartRepository;

	@Autowired
	private ProductCartConverter productCartConverter;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IProductService productService;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private CartConverter cartConverter;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public ProductCartEntity findOneByProductAndCart(ProductEntity product, CartEntity cart) {
		return productCartRepository.findOneByProductAndCart(product, cart);
	}

	@Override
	public ProductCartEntity findOne(Long id) {
		return productCartRepository.findOne(id);
	}

	@Override
	public int countByCart(CartEntity cart, String status) {
		return productCartRepository.countByCartAndStatus(cart, status);
	}

	@Override
	public List<ProductCartEntity> findByProductAndCart(ProductEntity product, CartEntity cart) {
		return productCartRepository.findByProductAndCart(product, cart);
	}

	@Override
	public int countByCartAndStatus(CartEntity cart, String status) {
		return productCartRepository.countByCartAndStatus(cart, status);
	}

	@Override
	public List<ProductCartEntity> findByCartAndStatus(CartEntity cart, String status) {
		return productCartRepository.findByCartAndStatus(cart, status);
	}

	@Override
	public List<ProductCartEntity> findByCart(CartEntity cart) {
		return productCartRepository.findByCart(cart);
	}

	@Override
	@Transactional
	public ProductCartDTO insert(Long productId, Long cartId) {
		ProductEntity productEntity = productService.findOne(productId);
		CartEntity cartEntity = cartService.findOne(cartId);
		ProductCartEntity entity = findOneByProductAndCart(productEntity, cartEntity);
		if (entity != null) {
			if (entity.getStatus().equals(SystemConstant.INACTIVE_PRODUCTCART)) {
				entity.setStatus(SystemConstant.ACTIVE_PRODUCTCART);
			}
			entity.setQuantity(entity.getQuantity() + 1);
		} else {
			// l??u gi?? ??? th???i ??i???m hi???n t???i v??o db. b???i v?? n???u thay ch??nh s??ch gi???m gi?? th?? s??? ???nh h?????ng ?????n h??a ????n.
			double price = productEntity.getPrice() - (productEntity.getPrice()*productEntity.getSale());
			entity = new ProductCartEntity(productEntity, cartEntity, 1, SystemConstant.ACTIVE_PRODUCTCART,price);
		}
		cartEntity.addProductCart(entity);
		productEntity.addProductCart(entity);
		entity = productCartRepository.save(entity);
		cartEntity = cartRepository.save(cartEntity);
		productEntity = productRepository.save(productEntity);
		return productCartConverter.toDto(entity);
	}

	// update l?? x??a s???n ph???m, thay ?????i trang th??i  == 0;
	@Override
	@Transactional
	public ProductCartDTO update(Long productId, Long cartId, int quantity,HashMap<Long, ProductCartDTO> cart) {
		ProductEntity productEntity = productService.findOne(productId);
		CartEntity cartEntity = cartService.findOne(cartId);
		ProductCartEntity entity = findOneByProductAndCart(productEntity, cartEntity);
		if (entity.getQuantity() == 0) {
			entity.setQuantity(0);
			entity.setStatus(SystemConstant.INACTIVE_PRODUCTCART);
			cart.remove(productId);		
		} else
			entity.setQuantity(quantity);

		cartEntity.addProductCart(entity);
		productEntity.addProductCart(entity);
		cartEntity = cartRepository.save(cartEntity);
		productEntity = productRepository.save(productEntity);

		entity = productCartRepository.save(entity);
		return productCartConverter.toDto(entity);
	}

	@Override
	public HashMap<Long, ProductCartDTO> addCart(long id, HashMap<Long, ProductCartDTO> cart) {
		ProductCartDTO itemCart = new ProductCartDTO();
		ProductEntity productEntity = productService.findOne(id);
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		Long cartId = cartService.getCartIdByUserId(userId);
		CartEntity cartEntity = cartService.findOne(cartId);
		ProductDTO productDTO = productConverter.toDto(productEntity);
		CartDTO cartDTO = cartConverter.toDto(cartEntity);
		if (productDTO != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getPrice());
			itemCart.setCart(cartDTO);
			itemCart.setProduct(productDTO);
			itemCart.setStatus(itemCart.getStatus());
			itemCart.setPrice(itemCart.getProduct().getSalePrice());
		} else {
			itemCart.setProduct(productDTO);
			itemCart.setCart(cartDTO);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(productDTO.getSalePrice());
			itemCart.setStatus(itemCart.getStatus());
			itemCart.setPrice(itemCart.getProduct().getSalePrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	@Override
	public HashMap<Long, ProductCartDTO> editCart(long id, int quantity, HashMap<Long, ProductCartDTO> cart) {
		ProductEntity productEntity = productService.findOne(id);
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		Long cartId = cartService.getCartIdByUserId(userId);
		CartEntity cartEntity = cartService.findOne(cartId);
		ProductDTO productDTO = productConverter.toDto(productEntity);
		CartDTO cartDTO = cartConverter.toDto(cartEntity);
		if (cart == null) {
			return cart;
		}
		ProductCartDTO itemCart = new ProductCartDTO();
		if (cart.containsKey(id)) {
			if (itemCart.getStatus() != SystemConstant.INACTIVE_PRODUCTCART) {
				itemCart = cart.get(id);
				itemCart.setQuantity(quantity);
				itemCart.setCart(cartDTO);
				itemCart.setProduct(productDTO);
				itemCart.setStatus(SystemConstant.ACTIVE_PRODUCTCART);
				double totalPrice = quantity * itemCart.getProduct().getSalePrice();
				itemCart.setTotalPrice(totalPrice);
			} else if (itemCart.getStatus() == SystemConstant.INACTIVE_PRODUCTCART) {
				cart.remove(id);
			}
		}
		cart.put(id, itemCart);
		return cart;
	}

	// ko xoa nua, ma chi chuyen status = 0, quantity = 0;
	// 1. khi so luong > 0 => sl = 0 && status = 0;
	// 2. sl == 0 , status = 0
	@Override
	@Transactional
	public void delete(Long productId, Long cartId) {
		List<ProductCartEntity> entity = findByCart(cartService.findOne(cartId));
		for (ProductCartEntity item : entity) {
			if (item.getProduct().getId() == productId) {
				item.setStatus(SystemConstant.INACTIVE_PRODUCTCART);
				item.setQuantity(0);
			}
		}
	}
	
	@Override
	@Transactional
	public void delete(Long cartId) {
		List<ProductCartEntity> entity = findByCart(cartService.findOne(cartId));
		for (ProductCartEntity item : entity) {
			item.setStatus(SystemConstant.INACTIVE_PRODUCTCART);
			item.setQuantity(0);
		}
	}
	
	// cai tong tien nay da tinh ca cai giam gia roi, con cai chua giam gia thi phai tinh
	@Override
	public double subTotalPrice(Long cartid) {
		double total = 0;
		List<ProductCartEntity> entities = findByCartAndStatus(cartService.findOne(cartid),
				SystemConstant.ACTIVE_PRODUCTCART);
		for (ProductCartEntity item : entities) {
			ProductEntity productEntity = productService.findOne(item.getProduct().getId());
			ProductDTO productDTO = productConverter.toDto(productEntity);
			total = total + ((double) productDTO.getSalePrice() * item.getQuantity());
		}
		return total;
	}

	@Override
	public double noPromotionPrice(Long cartid) {
		double total = 0;
		List<ProductCartEntity> entities = findByCartAndStatus(cartService.findOne(cartid),
				SystemConstant.ACTIVE_PRODUCTCART);
		for (ProductCartEntity item : entities) {
			ProductEntity productEntity = productService.findOne(item.getProduct().getId());
			ProductDTO productDTO = productConverter.toDto(productEntity);
			total = total + ((double) productDTO.getPrice() * item.getQuantity());
		}
		return total;
	}
	
	@Override
	public HashMap<Long, ProductCartDTO> getCart(Long cartId) {
		// long : product id , ProductCartDTO item cua no
		CartEntity cartEntity = cartService.findOne(cartId);
		CartDTO cartDTO = cartConverter.toDto(cartEntity);
		HashMap<Long, ProductCartDTO> cart = new HashMap<>();
		List<ProductCartEntity> entities = findByCartAndStatus(cartEntity, SystemConstant.ACTIVE_PRODUCTCART);
		for (ProductCartEntity item : entities) {
			ProductCartDTO result = new ProductCartDTO();
			ProductEntity productEntity = productService.findOne(item.getProduct().getId());
			ProductDTO productDTO = productConverter.toDto(productEntity);
			result.setId(item.getId());
			result.setCart(cartDTO);
			result.setProduct(productDTO);
			result.setQuantity(item.getQuantity());
			result.setStatus(item.getStatus());
			cart.put(item.getProduct().getId(), result);
		}
		return cart;
	}

	@Override
	public HashMap<Long, ProductCartDTO> deleteCart(long id, HashMap<Long, ProductCartDTO> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	@Override
	public List<ProductCartEntity> findByProduct_id(Long id) {
		return productCartRepository.findByProduct_id(id);
	}
}
