package com.webbanmatkinh.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.converter.ProductConverter;
import com.webbanmatkinh.service.ICategoryService;
import com.webbanmatkinh.service.IProductService;

@Controller(value = "controllerOfProductDetail")
@RequestMapping(value = "/chi-tiet-san-pham/")
public class ProductdetailController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired 
	private ICategoryService categoryService ;
	
	@Autowired 
	private ProductConverter productConverter;
	
	@RequestMapping(value = "{productcode}", method = RequestMethod.GET)
	public ModelAndView allProductByCategoryCode(@PathVariable(value = "productcode",required = false) long productcode) {
		ModelAndView mav = new ModelAndView("web/product_details");
		mav.addObject("categories", categoryService.findAll());
		
		mav.addObject("item", productConverter.toDto(productService.findOne(productcode)));
		String categoryCode = productService.findCategoryCodeById(productcode);
		Long id = categoryService.findOneByCode(categoryCode).getId();
		
		mav.addObject("products", productService.findByCategory_id(id));
		mav.addObject("quantityCategory", productService.countByCategory_id(id));
		mav.addObject("categoryname", categoryService.findOne(id).getName());
		return mav;	
	}
}
