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
import com.webbanmatkinh.dto.SliderDTO;
import com.webbanmatkinh.service.ISliderService;
import com.webbanmatkinh.util.MessageUtil;

@Controller(value = "sliderControllerOfAdmin")
public class SliderController {

	@Autowired
	private ISliderService sliderService;

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	UploadFile uploadFile;

	@RequestMapping(value = "/quan-tri/slider/tat-ca-slider", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, HttpServletRequest request,
			@RequestParam("limit") int limit) {
		SliderDTO model = new SliderDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/slider/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(sliderService.findAll(pageable));
		model.setTotalItem(sliderService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/slider/them", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView mav = new ModelAndView("admin/slider/add");
		return mav;
	}

	@RequestMapping(value = "/quan-tri/slider/them", method = RequestMethod.POST)
	public String add(@ModelAttribute("slider") SliderDTO slider, ModelMap model,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		if (file.isEmpty()) {
			model.addAttribute("message", "Vui long chon file");
		} else {
			String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
			String fileName = date + file.getOriginalFilename();
			slider.setImage(fileName);
			String imagePath = uploadFile.getBasePath() + File.separator + fileName;
			file.transferTo(new File(imagePath));
			model.addAttribute("model", slider);
			sliderService.insert(slider);
		}
		return "redirect:/quan-tri/slider/tat-ca-slider?page=1&limit=5";
	}
	
	// phai buoc dl len form, buoc dl len thanh cong. =>  ok lm sao ma sua duoc day.
	// lay id duoc r, tim duoc thong tin r
	@RequestMapping(value = "/quan-tri/slider/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/slider/edit");
		SliderDTO model = new SliderDTO();
		if (id != null) {
			model = sliderService.findById(id);
		}
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/slider/chinh-sua", method = RequestMethod.POST)
	public String update(@ModelAttribute("slider") SliderDTO slider, ModelMap model,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {	
		if (file.isEmpty()) {
			model.addAttribute("message", "Vui long chon file");
		} else {
			String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
			String fileName = date + file.getOriginalFilename();
			String imagePath = uploadFile.getBasePath() + File.separator + fileName;
			file.transferTo(new File(imagePath));
			model.addAttribute("model", slider);
			sliderService.update(slider);
		}
		return "redirect:/quan-tri/slider/tat-ca-slider?page=1&limit=5";
	}
}
