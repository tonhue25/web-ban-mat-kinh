package com.webbanmatkinh.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanmatkinh.dto.ProductDTO;
import com.webbanmatkinh.service.IProductService;

// can co value de phan biet ProductAPI cua web
@RestController(value = "productAPIOfAdmin")
public class ProductAPI {
	
	@Autowired
	private IProductService productService;
	
	@PostMapping("/api/product")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return productService.insert(productDTO);
	}
	
	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO updateProduct) {
		return productService.update(updateProduct);
	}
	
	// xoa hang san pham
	@DeleteMapping("/api/product")
	public void deleteProduct(@RequestBody long[] ids) {
		productService.delete(ids);
	}
}
