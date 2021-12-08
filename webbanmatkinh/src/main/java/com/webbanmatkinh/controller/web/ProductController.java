package com.webbanmatkinh.controller.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.webbanmatkinh.entity.ProductEntity;
import com.webbanmatkinh.service.*;

@Controller(value = "productControllerOfWeb")
@RequestMapping(value = "/san-pham")
public class ProductController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public String showProduct(@RequestParam(value = "name", required = false) String name, ModelMap model,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(0);
		int pageSize = size.orElse(6);
		Pageable pageable = new PageRequest(currentPage, pageSize);
		Page<ProductEntity> resultList = null;
		if (StringUtils.hasText(name)) {
			if (name.equals("mat-kinh-tre-em") | name.equals("mat-kinh-nam") | name.equals("mat-kinh-nu")) {
				Long id = categoryService.findOneByCode(name).getId();
				resultList = productService.findByCategory_id(id, pageable);
				model.addAttribute("name", name);
			}
			else {
				resultList = productService.findByNameContaining(name, pageable);
				model.addAttribute("name", name);
			}
		} 
		else {
			resultList = productService.findAllProductEntity(pageable);
		}
		int totalPages = resultList.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(0, currentPage - 1);
			int end = Math.min(currentPage + 1, totalPages);
			if (totalPages > 6) {
				if (end == totalPages)
					start = end - 6;
				else if (start == 0)
					end = start + 6;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("products", resultList);
		model.addAttribute("categories", categoryService.findAll());
		return "web/shop";
	}
}
