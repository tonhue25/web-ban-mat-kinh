/*package com.webbanmatkinh.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webbanmatkinh.dto.CartDTO;
import com.webbanmatkinh.service.ICartService;

@Controller
public class PhuController {

	@Autowired
	private ICartService cartService;
	
	@RequestMapping(value = "/them-gio-hang/{id}", method = RequestMethod.GET)
	public String addCart(HttpServletRequest request,
			HttpSession session,@PathVariable(value = "id") long id) {
		HashMap<Long,CartDTO> cart = (HashMap<Long,CartDTO>)session.getAttribute("Cart");
		
		if(cart == null) {
			cart = new HashMap<Long,CartDTO>();
		}
		
		// add ben ngoai de no hien thi thoi, ko luu xg db
		cart = cartService.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.totalPrice(cart));
		
		return "redirect:"+request.getHeader("Referer");
	}
	
	// phai lấy đc đối tượng để lưu xuống db
	@RequestMapping(value = "/sua-gio-hang/{id}/{quantity}", method = RequestMethod.GET)
	public String editCart(HttpServletRequest request,
			HttpSession session,@PathVariable(value = "id") long id,
			@PathVariable(value = "quantity") int quantity) {
		HashMap<Long,CartDTO> cart = (HashMap<Long,CartDTO>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long,CartDTO>();
		}
		cart = cartService.editCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/xoa-gio-hang/{id}", method = RequestMethod.GET)
	public String deteteCart(HttpServletRequest request,
			HttpSession session,@PathVariable(value = "id") long id) {
		HashMap<Long,CartDTO> cart = (HashMap<Long,CartDTO>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long,CartDTO>();
		}
		cart = cartService.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
}
*/