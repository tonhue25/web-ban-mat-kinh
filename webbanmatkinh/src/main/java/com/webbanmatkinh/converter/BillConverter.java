package com.webbanmatkinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webbanmatkinh.dto.BillDTO;
import com.webbanmatkinh.entity.BillEntity;
import com.webbanmatkinh.repository.UserRepository;
import com.webbanmatkinh.service.IUserService;

@Component
public class BillConverter {
	
	@Autowired
	private IUserService userService;
	
	public BillDTO toDto(BillEntity entity) {
		BillDTO result = new BillDTO();		
		result.setId(entity.getId());
		result.setUserId(entity.getUser().getId());
		result.setTotal(entity.getTotal());
		result.setSubtotal(entity.getSubtotal());
		result.setTax(entity.getTax());
		result.setShipping(entity.getShipping());
		return result;
	}
	
	// moi hoan toan
	public BillEntity toEntity(BillDTO dto) {
		BillEntity result = new BillEntity();
		result.setUser(userService.findOne(dto.getUserId()));;
		result.setTotal(dto.getTotal());
		result.setSubtotal(dto.getSubtotal());
		result.setTax(dto.getTax());
		result.setShipping(dto.getShipping());
		return result;
	}
	
	// sua , sua nhieu truong
	public BillEntity toEntity(BillEntity result,BillDTO dto) {
		result.setUser(userService.findOne(dto.getUserId()));;
		result.setTotal(dto.getTotal());
		result.setSubtotal(dto.getSubtotal());
		result.setTax(dto.getTax());
		result.setShipping(dto.getShipping());
		return result;
	}
	// sua, dung lm chuc nang xoa: chuyen trang thai don hang tu 0 => 1, khong xoa bill
	/*public BillEntity toEntity_Delete(BillEntity result,BillDTO dto) {
		result.setUser(userRepository.findOne(dto.getUserId()));;
		result.setTotal(dto.getTotal());
		// set trang thai don hang ve 0
		result.setStatus(SystemConstant.CANCEL);
		result.setPaymentmethod(dto.getPaymentmethod());
		result.setSubtotal(dto.getSubtotal());
		result.setTax(dto.getTax());
		result.setShipping(dto.getShipping());
		return result;
	}*/
}
