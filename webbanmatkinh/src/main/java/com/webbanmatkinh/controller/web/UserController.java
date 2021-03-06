package com.webbanmatkinh.controller.web;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanmatkinh.constant.SystemConstant;
import com.webbanmatkinh.converter.UserConverter;
import com.webbanmatkinh.dto.CartDTO;
import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.entity.UserEntity;
import com.webbanmatkinh.repository.UserRepository;
import com.webbanmatkinh.service.ICartService;
import com.webbanmatkinh.service.IUserService;
import com.webbanmatkinh.util.SecurityUtils;
import com.webbanmatkinh.util.URLUtils;

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

	@Autowired
	public JavaMailSender mailSender;

	@RequestMapping(value = "/dang-ki", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UserDTO());
		return mav;
	}

	@RequestMapping(value = "/dang-ki", method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("user") UserDTO user) {
		ModelAndView mav = new ModelAndView("register");
		UserDTO userDTO = userService.insert(user);
		if (userDTO != null) {
			mav.addObject("statusUser", "????NG K?? TH??NH C??NG");
			Long userId = userService.findOneByUserNameAndStatus(user.getUserName(), SystemConstant.ACTIVE_STATUS)
					.getId();
			CartDTO dto = cartService.insert(userId);
			if (dto != null) {

				return new ModelAndView("redirect:/dang-nhap");
			} else {
				return mav;
			}
		} else
			return mav;
	}

	// tai khoan 1 : admin redirect den quan-tri/trang-chu, 2 : nguoi dung tra ve web/myaccount.
	@RequestMapping(value = "/tai-khoan", method = RequestMethod.GET)
	public String myaccount(ModelMap model) {
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS).getId();
		UserEntity entity = userRepository.findOne(userId);
		if(entity.getId()!=null) {
			if(entity.getRole().getId() == 1) {
				return "redirect:/quan-tri/trang-chu";
			}
		}
		UserDTO user = userConverter.toDto(entity);
		model.addAttribute("user", user);
		return "web/myaccount";
	}

	@RequestMapping(value = "/tai-khoan", method = RequestMethod.POST)
	public String update(@ModelAttribute("user") UserDTO user, ModelMap model) {
		Long userId = userService.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), SystemConstant.ACTIVE_STATUS)
				.getId();
		user.setId(userId);
		user.setStatus(SystemConstant.ACTIVE_STATUS);
		user.setRoleid(SystemConstant.ROLE_USER);
		user.setPassword(userService.findOne(userId).getPassword());
		model.addAttribute("model", user);
		userService.update(user);
		return "redirect:/tai-khoan";
	}

	// QU??N M???T KH???U.
	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.GET)
	public ModelAndView forgotPassword1() {
		ModelAndView mav = new ModelAndView("forgotPassword");
		return mav;
	}

	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.POST)
	public String forgotPassword2(HttpServletRequest request) {
		String email = request.getParameter("email");
		SecureRandom rnd = new SecureRandom();
		Base64.Encoder base64Encoder = Base64.getUrlEncoder();
		byte[] randomBytes = new byte[24];
		rnd.nextBytes(randomBytes);
		String tokenStr1 = base64Encoder.encodeToString(randomBytes);

		userService.updateResetPassword(tokenStr1, email);
		String resetPasswordLink = URLUtils.getSiteURL(request) + "/doi-mat-khau?token=" + tokenStr1;
		sendMail(email, resetPasswordLink);

		return "redirect:/quen-mat-khau";
	}

	private void sendMail(String email, String resetPasswordLink) {
		MimeMessage mail = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail);
		try {
			helper.setFrom("contactuspandashop@gmail.com", "PandaShop Support");
			helper.setTo(email);
			// cho ph??p reply ng?????i g???i.
			String subject = "Here's the link to reset your password";
			String content = "<p>Hello,</p>" + "<p>You have requested to reset your password</p>"
					+ "<p>Clink the link below to change your password.</p>" + "<p><a href  = \"" + resetPasswordLink
					+ "\">Change my password</a></p>"
					+ "<p>Ignore this email if you do remember your password or you have not made the request</p>";
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(mail);
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/doi-mat-khau", method = RequestMethod.GET)
	public String resetPassword1(@Param(value = "token") String token, ModelMap model) {
		// l???y token t??? db
		UserEntity entity = userService.get(token);
		if (entity == null) {
			return null;
		} else {
			model.addAttribute("token", token);
			model.addAttribute("pageTitle", "Reset your password!!");
			return "resetPassword";
		}
	}

	@RequestMapping(value = "/doi-mat-khau", method = RequestMethod.POST)
	public String resetPassword2(HttpServletRequest request, ModelMap model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		UserEntity entity = userService.get(token);
		if (entity == null) {
			return null;
		} else {
			userService.updatePassword(entity, password);
			model.addAttribute("message", "You have successfully changed your password!!");
		}
		return "resetPassword";
	}
}
