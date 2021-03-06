package com.webbanmatkinh.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanmatkinh.dto.UserDTO;
import com.webbanmatkinh.service.IUserService;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {

	@Autowired
	private IUserService userService;

	@PostMapping("/api/user")
	public UserDTO createUser(@RequestBody UserDTO dto) {
		return userService.insertByAdmin(dto);
	}

	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO userDTO) {
		return userService.updateByAdmin(userDTO);
	}

	// thay doi trang thai cua user.
	@DeleteMapping("/api/user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}
