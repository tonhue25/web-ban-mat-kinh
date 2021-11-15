package com.webbanmatkinh.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.dto.ProductCartDTO;
import com.webbanmatkinh.service.ICartService;
import com.webbanmatkinh.service.IProductCartService;
import com.webbanmatkinh.service.IProductService;
import com.webbanmatkinh.service.ISliderService;
import com.webbanmatkinh.service.IUserService;
import com.webbanmatkinh.util.SecurityUtils;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private ISliderService sliderService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private IProductCartService productCartService;

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpSession session) {
		ModelAndView mav = new ModelAndView("web/home");
		try {
			Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
			Long cartId = cartService.getCartIdByUserId(userId);
			session.setAttribute("totalPriceCart", productCartService.subTotalPrice(cartId));
			session.setAttribute("noPromotionPrice", productCartService.noPromotionPrice(cartId));
			HashMap<Long, ProductCartDTO> cart = (HashMap<Long, ProductCartDTO>) session.getAttribute("Cart");
			if (cart == null) {
				cart = new HashMap<Long, ProductCartDTO>();
			}
			cart = productCartService.getCart(cartId);
			session.setAttribute("Cart", cart);
		}catch(Exception e) {}
		finally {
			mav.addObject("sliders", sliderService.findAll());
			mav.addObject("product", productService.findAll());
			
			mav.addObject("hotproduct", productService.findAllByHotproduct(SystemConstant.HOT_PRODUCT));
			mav.addObject("quantityHot", productService.countByHotproduct(SystemConstant.HOT_PRODUCT));
			
			mav.addObject("newproduct", productService.findAllByNewproduct(SystemConstant.NEW_PRODUCT));
			mav.addObject("quantityNew", productService.countByNewproduct(SystemConstant.NEW_PRODUCT));
		}
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("web/contact");
		return mav;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("web/about");
		return mav;
	}
		
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cartPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("web/cart");
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		Long cartId = cartService.getCartIdByUserId(userId);
		session.setAttribute("totalPriceCart", productCartService.subTotalPrice(cartId));
		session.setAttribute("noPromotionPrice", productCartService.noPromotionPrice(cartId));
		HashMap<Long, ProductCartDTO> cart = (HashMap<Long, ProductCartDTO>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, ProductCartDTO>();
		}
		cart = productCartService.getCart(cartId);
		session.setAttribute("Cart", cart);
		return mav;
	}
}
