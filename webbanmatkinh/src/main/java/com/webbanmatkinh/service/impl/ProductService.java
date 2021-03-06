package com.webbanmatkinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanmatkinh.converter.ProductConverter;
import com.webbanmatkinh.dto.ProductDTO;
import com.webbanmatkinh.entity.CategoryEntity;
import com.webbanmatkinh.entity.ProductEntity;
import com.webbanmatkinh.repository.ProductRepository;
import com.webbanmatkinh.service.ICategoryService;
import com.webbanmatkinh.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IProductService productService;

	@Autowired
	private ProductConverter productConverter;

	@Autowired
	private ICategoryService categoryService;

	@Override
	public ProductEntity findOne(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public int countByCategory_id(Long category_id) {
		return productRepository.countByCategory_id(category_id);
	}

	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
		for (ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	/*@Override
	public List<ProductDTO> findAllByCategory(Pageable pageable, Long categoryid) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = findByCategory_id(categoryid, pageable).getContent();
		for (ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}*/
	
	@Override
	public List<ProductEntity> findByCategory_id(Long category_id) {
		return productRepository.findByCategory_id(category_id);
	}

	

	@Override
	public int getTotalItem() {
		return (int) productRepository.count();
	}

	@Override
	public String findCategoryCodeById(Long id) {
		ProductEntity result = productService.findOne(id);
		return result.getCategory().getCode();
	}

	@Override
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		CategoryEntity category = categoryService.findOneByCode(dto.getCategoryCode());
		ProductEntity productEntity = productConverter.toEntity(dto);
		productEntity.setCategory(category);
		productEntity = productRepository.save(productEntity);
		return productConverter.toDto(productEntity);
	}

	// sua
	@Override
	@Transactional
	public ProductDTO update(ProductDTO dto) {
		ProductEntity oldProduct = productService.findOne(dto.getId());
		ProductEntity updateProduct = productConverter.toEntity(oldProduct, dto);
		updateProduct.setCategory(categoryService.findOneByCode(dto.getCategoryCode()));
		return productConverter.toDto(productRepository.save(oldProduct));
	}

	// x??a s???n ph???m.
	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			productRepository.delete(id);
		}
	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public void deleteByCategory(Long categoryid) {
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item : entities) {
			if (item.getCategory().getId() == categoryid) {
				productRepository.delete(item);
			}
		}
	}

	@Override
	public List<ProductEntity> findByHotproduct(String hotProduct) {
		return productRepository.findByHotproduct(hotProduct);
	}

	@Override
	public List<ProductEntity> findByNewproduct(String newProduct) {
		return productRepository.findByNewproduct(newProduct);
	}

	@Override
	public Page<ProductEntity> findByHotproduct(String hotProduct, Pageable pageable) {
		return productRepository.findByHotproduct(hotProduct, pageable);
	}

	@Override
	public Page<ProductEntity> findByNewproduct(String newProduct, Pageable pageable) {
		return productRepository.findByNewproduct(newProduct, pageable);
	}

	@Override
	public List<ProductDTO> findAllByNewproduct(String newProduct) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = findByNewproduct(newProduct);
		for (ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public List<ProductDTO> findAllByNewproduct(Pageable pageable, String newProduct) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = findByNewproduct(newProduct, pageable).getContent();
		for (ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public List<ProductDTO> findAllByHotproduct(String hotProduct) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = findByHotproduct(hotProduct);
		for (ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public List<ProductDTO> findAllByHotproduct(Pageable pageable, String hotProduct) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = findByHotproduct(hotProduct, pageable).getContent();
		for (ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public int countByNewproduct(String newProduct) {
		return productRepository.countByNewproduct(newProduct);
	}

	@Override
	public int countByHotproduct(String hotProduct) {
		return productRepository.countByHotproduct(hotProduct);
	}

	@Override
	public List<ProductEntity> findByNameContaining(String name) {
		return productRepository.findByNameContaining(name);
	}

	@Override
	public Page<ProductEntity> findByNameContaining(String name, Pageable pageable) {
		return productRepository.findByNameContaining(name, pageable);
	}

	@Override
	public Page<ProductEntity> findAllProductEntity(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	@Override
	public Page<ProductEntity> findByCategory_id(Long category_id, Pageable pageable) {
		return productRepository.findByCategory_id(category_id, pageable);
	}

}
