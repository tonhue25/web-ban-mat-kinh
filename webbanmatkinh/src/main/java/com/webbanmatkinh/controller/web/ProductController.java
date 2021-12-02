package com.webbanmatkinh.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.dto.ProductDTO;
import com.webbanmatkinh.service.ICategoryService;
import com.webbanmatkinh.service.IProductService;

@Controller(value = "productControllerOfWeb")
@RequestMapping(value = "/san-pham")
public class ProductController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "{categoryCode}", method = RequestMethod.GET)
	public ModelAndView showProduct(
			@PathVariable(value = "categoryCode", required = false) String categoryCode, @RequestParam("page") int page,
			HttpServletRequest request, @RequestParam("limit") int limit) {
		ModelAndView mav = new ModelAndView("web/shop");
		mav.addObject("categories", categoryService.findAll());
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		if (categoryCode.contains("danh-sach")) {
			model.setListResult(productService.findAll(pageable));
			model.setTotalItem(productService.getTotalItem());
		}
		else if (categoryCode.contains("hot-products")) {
			model.setListResult(productService.findAllByHotproduct(pageable, SystemConstant.HOT_PRODUCT));
			model.setTotalItem(productService.countByHotproduct(SystemConstant.HOT_PRODUCT));
		} else if (categoryCode.contains("new-products")) {
			model.setListResult(productService.findAllByNewproduct(pageable, SystemConstant.NEW_PRODUCT));
			model.setTotalItem(productService.countByNewproduct(SystemConstant.NEW_PRODUCT));
		} else {
			Long id = categoryService.findOneByCode(categoryCode).getId();
			model.setListResult(productService.findAllByCategory(pageable, id));
			model.setTotalItem(productService.countByCategory_id(id));
		}
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("products", model);
		return mav;
	}
}