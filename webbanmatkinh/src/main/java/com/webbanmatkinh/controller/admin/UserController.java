package com.webbanmatkinh.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.converter.UserConverter;
import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.service.IRoleService;
import com.webbanmatkinh.service.IUserService;
import com.webbanmatkinh.util.MessageUtil;

@Controller(value = "userControllerOfAdmin")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/quan-tri/user/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
			HttpServletRequest request,
			@RequestParam("limit") int limit) {
		UserDTO model = new UserDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/user/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(userService.findAll(pageable));
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/user/chinh-sua" , method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id" , required = false) Long id,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserDTO model = new UserDTO();
		if(id!=null) {
			model = userConverter.toDto(userService.findOne(id));
		}
		if(request.getParameter("message")!=null) {
			Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("roles", roleService.findAll());
		mav.addObject("model", model);
		return mav;
	}
}
