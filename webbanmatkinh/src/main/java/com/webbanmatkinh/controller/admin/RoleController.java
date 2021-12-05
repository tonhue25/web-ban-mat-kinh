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

import com.webbanmatkinh.converter.RoleConverter;
import com.webbanmatkinh.dto.RoleDTO;
import com.webbanmatkinh.service.IRoleService;
import com.webbanmatkinh.util.MessageUtil;

@Controller(value = "roleControllerOfAdmin")
public class RoleController {
	
	@Autowired 
	private IRoleService roleService ;
	
	@Autowired 
	private RoleConverter roleConverter ;
	
	@Autowired
	private MessageUtil messageUtil;
		
	// mac dinh page va limit phai co
	@RequestMapping(value = "/quan-tri/vai-tro/danh-sach" , method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, HttpServletRequest request,
			@RequestParam("limit") int limit) {
		
		RoleDTO model = new RoleDTO();
		model.setPage(page);
		model.setLimit(limit);
		
		ModelAndView mav = new ModelAndView("admin/role/list");
		
		Pageable pageable = new PageRequest(page-1, limit);
		
		model.setListResult(roleService.findAll(pageable));
		model.setTotalItem(roleService.getTotalItem());
		model.setTotalPage((int)Math.ceil((double)model.getTotalItem()/model.getLimit()));
		if(request.getParameter("message")!=null) {
			Map<String,String> message= messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/vai-tro/chinh-sua" , method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id" , required = false) Long id,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/role/edit");
		RoleDTO model = new RoleDTO();
		if(id!=null) {
			model = roleConverter.toDto(roleService.findOne(id));
		}
		if(request.getParameter("message")!=null) {
			Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
}
