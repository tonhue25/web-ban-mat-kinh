package com.webbanmatkinh.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanmatkinh.dto.RoleDTO;
import com.webbanmatkinh.service.IRoleService;

@RestController(value = "roleAPIOfAdmin")
public class RoleAPI {
	
	@Autowired
	private IRoleService roleService;
	
	@PostMapping("/api/role")
	public RoleDTO createCategory(@RequestBody RoleDTO dto) {
		return roleService.insert(dto);
	}
	
	@PutMapping("/api/role")
	public RoleDTO updateCategory(@RequestBody RoleDTO dto) {
		return roleService.update(dto);
	}
	
	// không cho xóa quyền. chỉ cho sửa hoặc thêm quyền thôi.
}
