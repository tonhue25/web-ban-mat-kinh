package com.webbanmatkinh.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanmatkinh.dto.SliderDTO;
import com.webbanmatkinh.service.ISliderService;

@RestController(value = "sliderAPIOfAdmin")
public class SliderAPI {
	
	@Autowired
	private ISliderService sliderService;
	
	@PostMapping("/api/slider")
	public SliderDTO createProduct(@RequestBody SliderDTO sliderDTO) {
		return sliderService.insert(sliderDTO);
	}
	
	@PutMapping("/api/slider")
	public SliderDTO updateProduct(@RequestBody SliderDTO sliderDTO) {
		return sliderService.update(sliderDTO);
	}
	// ho tro xoa nhieu bai viet => nhan mang cac id sp can xoa
	@DeleteMapping("/api/slider")
	public void deleteProduct(@RequestBody long[] ids) {
		sliderService.delete(ids);
	}
}
