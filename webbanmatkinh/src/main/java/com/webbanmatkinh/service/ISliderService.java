package com.webbanmatkinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.webbanmatkinh.dto.SliderDTO;

public interface ISliderService {
	
	public List<SliderDTO> findAll();
	int getTotalItem();
	
	SliderDTO insert(SliderDTO dto);
	SliderDTO update(SliderDTO dto);
	
	void delete(long[] ids);
	
	SliderDTO findById(long id);
	List<SliderDTO> findAll(Pageable pageable);
}
