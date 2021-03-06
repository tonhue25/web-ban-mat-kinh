package com.webbanmatkinh.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.converter.UserConverter;
import com.webbanmatkinh.dto.BillDTO;
import com.webbanmatkinh.dto.ProductCartDTO;
import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.entity.UserEntity;
import com.webbanmatkinh.repository.UserRepository;
import com.webbanmatkinh.service.IBillService;
import com.webbanmatkinh.service.ICartService;
import com.webbanmatkinh.service.IProductCartService;
import com.webbanmatkinh.service.IUserService;
import com.webbanmatkinh.util.SecurityUtils;

@Controller(value = "billController")
public class BillController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IBillService billService;
	
	@Autowired
	private IProductCartService productCartService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;
	
	//ok
	@RequestMapping("/phan-hoi")
	public ModelAndView confirmation(@RequestParam("ship") String ship,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/reply");
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), 
				SystemConstant.ACTIVE_STATUS).getId();
		Long cartId = cartService.getCartIdByUserId(userId);
		double shipping  = 0;
		if (ship.contains("standard")) {
			shipping = 0;
		} else if (ship.contains("express")) {
			shipping = 10;
		}
		else if (ship.contains("next_business")) {
			shipping = 20;
		}
		double subtotal = productCartService.subTotalPrice(cartId);
		double total = subtotal + SystemConstant.TAX +shipping;
		
		BillDTO bill  = new BillDTO(userId, total, subtotal, SystemConstant.TAX, shipping);
		BillDTO dto = billService.insert(bill);
		if(dto!=null) {
			productCartService.delete(cartId);
		}
		return mav;
	}
	
	@RequestMapping(value = "/dat-hang", method = RequestMethod.GET)
	public ModelAndView checkOutPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("web/checkout");
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), 
				SystemConstant.ACTIVE_STATUS).getId();
		Long cartId = cartService.getCartIdByUserId(userId);
		UserEntity entity = userRepository.findOne(userId);
		UserDTO user = userConverter.toDto(entity);
		HashMap<Long, ProductCartDTO> cart = (HashMap<Long, ProductCartDTO>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, ProductCartDTO>();
		}
		cart = productCartService.getCart(cartId);
		session.setAttribute("totalPriceCart", productCartService.subTotalPrice(cartId));
		session.setAttribute("Cart", cart);
		session.setAttribute("noPromotionPrice", productCartService.noPromotionPrice(cartId));
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value = "/hoa-don", method = RequestMethod.GET)
	public ModelAndView invoice() {
		ModelAndView mav = new ModelAndView("web/invoice");
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), 
				SystemConstant.ACTIVE_STATUS).getId();
		BillDTO bill = new BillDTO();
		System.out.println(userId);
		bill.setListResult(billService.findAllByUser_id(userId));
		mav.addObject("bill", bill);
		return mav;
	}
}
