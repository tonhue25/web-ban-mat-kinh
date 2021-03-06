package com.webbanmatkinh.controller.admin;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.api.admin.UploadFile;
import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.converter.ProductConverter;
import com.webbanmatkinh.dto.ProductDTO;
import com.webbanmatkinh.service.ICategoryService;
import com.webbanmatkinh.service.IProductService;
import com.webbanmatkinh.util.MessageUtil;

@Controller(value = "productControllerOfAdmin")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ProductConverter productConverter;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	UploadFile uploadFile;

	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, HttpServletRequest request,
			@RequestParam("limit") int limit) {

		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);

		ModelAndView mav = new ModelAndView("admin/product/list");

		Pageable pageable = new PageRequest(page - 1, limit);

		model.setListResult(productService.findAll(pageable));
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

	//ok
	@RequestMapping(value = "/quan-tri/san-pham/them", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView mav = new ModelAndView("admin/product/add");
		mav.addObject("categories", categoryService.findAll());
		return mav;
	}

	//ok
	@RequestMapping(value = "/quan-tri/san-pham/them", method = RequestMethod.POST)
	public String add(@ModelAttribute("product") ProductDTO product, ModelMap model,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		if (file.isEmpty()) {
			model.addAttribute("message", "Vui long chon file");
		} else {
			String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
			String fileName = date + file.getOriginalFilename();
			product.setImage(fileName);
			product.setHotProduct(SystemConstant.NO_NEW_PRODUCT);
			product.setNewProduct(SystemConstant.NEW_PRODUCT);
			/*product.setStatus(SystemConstant.ACTIVE_STATUS);*/
			String imagePath = uploadFile.getBasePath() + File.separator + fileName;
			file.transferTo(new File(imagePath));
			model.addAttribute("model", product);
			productService.insert(product);
		}
		return "redirect:/quan-tri/san-pham/danh-sach?page=1&limit=5";
	}

	//ok
	@RequestMapping(value = "/quan-tri/san-pham/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/product/edit");
		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = productConverter.toDto(productService.findOne(id));
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	// ok
	@RequestMapping(value = "/quan-tri/san-pham/chinh-sua", method = RequestMethod.POST)
	public String update(@ModelAttribute("product") ProductDTO product, ModelMap model,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {	
		if (file.isEmpty()) {
			model.addAttribute("message", "Vui long chon file");
		} else {
			String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
			String fileName = date + file.getOriginalFilename();
			String imagePath = uploadFile.getBasePath() + File.separator + fileName;
			file.transferTo(new File(imagePath));
			product.setImage(fileName);
			product.setHotProduct(SystemConstant.NO_NEW_PRODUCT);
			product.setNewProduct(SystemConstant.NO_NEW_PRODUCT);
			/*product.setStatus(SystemConstant.ACTIVE_STATUS);*/
			model.addAttribute("model", product);
			productService.update(product);
		}
		return "redirect:/quan-tri/san-pham/danh-sach?page=1&limit=5";
	}
}
