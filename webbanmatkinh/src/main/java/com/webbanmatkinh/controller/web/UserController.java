package com.webbanmatkinh.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.converter.UserConverter;
import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.entity.UserEntity;
import com.webbanmatkinh.repository.UserRepository;
import com.webbanmatkinh.service.ICartService;
import com.webbanmatkinh.service.IUserService;
import com.webbanmatkinh.util.SecurityUtils;

@Controller
public class UserController {

	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	// ok
	@RequestMapping(value = "/dang-ki", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UserDTO());
		return mav;
	}

	// ok
	@RequestMapping(value = "/dang-ki", method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("user") UserDTO user) {
		ModelAndView mav = new ModelAndView("register");
		UserDTO userDTO = userService.insert(user);	
		if (userDTO != null) {
			mav.addObject("statusUser", "ĐĂNG KÍ THÀNH CÔNG");
			Long userId = userService.findOneByUserNameAndStatus(user.getUserName(), SystemConstant.ACTIVE_STATUS).getId();
			cartService.insert(userId); 
			return new ModelAndView("redirect:/dang-nhap");
		}
		else return mav;
	}
	
	// ok
	@RequestMapping(value = "/tai-khoan", method = RequestMethod.GET)
	public ModelAndView myaccount() {
		ModelAndView mav = new ModelAndView("web/myaccount");
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		UserEntity entity = userRepository.findOne(userId);
		UserDTO user = userConverter.toDto(entity);
		mav.addObject("user", user);
		return mav;
	}
	
	//ok
	@RequestMapping(value = "/tai-khoan", method = RequestMethod.POST)
	public String update(@ModelAttribute("user") UserDTO user, ModelMap model) {
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		user.setId(userId);
		user.setStatus(SystemConstant.ACTIVE_STATUS); 
		user.setRoleid(SystemConstant.ROLE_USER);
		user.setPassword(userService.findOne(userId).getPassword());	
		model.addAttribute("model", user);
		userService.update(user);
		return "redirect:/tai-khoan";
	}
}
