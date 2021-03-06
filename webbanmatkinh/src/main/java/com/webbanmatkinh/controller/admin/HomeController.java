package com.webbanmatkinh.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.service.ICategoryService;
import com.webbanmatkinh.service.IProductService;
import com.webbanmatkinh.service.IUserService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICategoryService categoryService;
	
	
	@RequestMapping(value = "/quan-tri/trang-chu" , method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		mav.addObject("product", productService.getTotalItem());
		mav.addObject("user", userService.getTotalItem());
		mav.addObject("category", categoryService.getTotalItem());
		return mav;
	}
}
