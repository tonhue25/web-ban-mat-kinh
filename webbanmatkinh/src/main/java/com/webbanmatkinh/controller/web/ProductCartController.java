package com.webbanmatkinh.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.dto.ProductCartDTO;
import com.webbanmatkinh.entity.CartEntity;
import com.webbanmatkinh.service.ICartService;
import com.webbanmatkinh.service.IProductCartService;
import com.webbanmatkinh.service.IUserService;
import com.webbanmatkinh.util.SecurityUtils;

@Controller(value = "productCartController")
public class ProductCartController {
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IProductCartService productCartService;
	
	@RequestMapping(value = "/them-gio-hang/{id}", method = RequestMethod.GET)
	public String addCart(@PathVariable(value = "id") long id,
			HttpSession session,
			HttpServletRequest request) {
		
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		Long cartId = cartService.getCartIdByUserId(userId);
		CartEntity cartEntity = cartService.findOne(cartId);
		
		productCartService.insert(id,cartId);
		
		HashMap<Long,ProductCartDTO> cart = (HashMap<Long,ProductCartDTO>)session.getAttribute("Cart");
		
		if(cart == null) {
			cart = new HashMap<Long,ProductCartDTO>();
		}
		
		cart = productCartService.getCart(cartId);
		session.setAttribute("Cart", cart);
		
		session.setAttribute("totalQuantityCart", productCartService.countByCart(cartEntity,SystemConstant.ACTIVE_PRODUCTCART));
		session.setAttribute("totalPriceCart", productCartService.subTotalPrice(cartId));
		
		return "redirect:"+request.getHeader("Referer");
	}
	
	// lm chuc nang xoa
	@RequestMapping(value = "/xoa-gio-hang/{id}", method = RequestMethod.GET)
	public String deteteCart(HttpServletRequest request,
			HttpSession session,@PathVariable(value = "id") long id) {
		HashMap<Long,ProductCartDTO> cart = (HashMap<Long,ProductCartDTO>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long,ProductCartDTO>();
		}
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		Long cartId = cartService.getCartIdByUserId(userId);
		cart = productCartService.getCart(cartId);
		
		// xoa trong db
		productCartService.delete(id, cartId);
		
		// xoa trong gio ok roi, con xoa trong db lm sao
		productCartService.deleteCart(id, cart);
		CartEntity cartEntity = cartService.findOne(cartId);
		session.setAttribute("totalQuantityCart", productCartService.countByCart(cartEntity,SystemConstant.ACTIVE_PRODUCTCART));
		session.setAttribute("totalPriceCart", productCartService.subTotalPrice(cartId));
		session.setAttribute("Cart", cart);
		return "redirect:"+request.getHeader("Referer");
	}

	// neu sl cua san pham  = 0 , xoa san pham trong list do di , ????
	// cai xoa san pham khi sl = 0 , no hoi cham chap, nhung ma ko loi
	@RequestMapping(value = "/sua-gio-hang/{id}/{quantity}", method = RequestMethod.GET)
	public String editCart(HttpServletRequest request,
			HttpSession session,@PathVariable(value = "id") long id,
			@PathVariable(value = "quantity") int quantity) {
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		
		Long cartId = cartService.getCartIdByUserId(userId);
			
		HashMap<Long,ProductCartDTO> cart = (HashMap<Long,ProductCartDTO>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long,ProductCartDTO>();
		}
		cart = productCartService.getCart(cartId);
		productCartService.update(id, cartId, quantity,cart);
		cart = productCartService.editCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		CartEntity cartEntity = cartService.findOne(cartId);
		session.setAttribute("totalQuantityCart", productCartService.countByCart(cartEntity,SystemConstant.ACTIVE_PRODUCTCART));
		session.setAttribute("totalPriceCart", productCartService.subTotalPrice(cartId));
		return "redirect:"+request.getHeader("Referer");
	}
}
