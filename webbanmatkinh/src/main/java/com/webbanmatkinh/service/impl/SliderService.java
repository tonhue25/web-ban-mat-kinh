package com.webbanmatkinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webbanmatkinh.converter.SliderConverter;
import com.webbanmatkinh.dto.SliderDTO;
import com.webbanmatkinh.entity.SliderEntity;
import com.webbanmatkinh.repository.SliderRepository;
import com.webbanmatkinh.service.ISliderService;

@Service
public class SliderService implements ISliderService{
	
	@Autowired
	private SliderRepository sliderRepository;
	
	@Autowired
	private SliderConverter sliderConverter;
	
	@Override
	public List<SliderDTO> findAll(){
		List<SliderDTO> models= new ArrayList<>();
		List<SliderEntity>entities =  sliderRepository.findAll();
		for(SliderEntity item : entities) {
			SliderDTO sliderDTO = sliderConverter.toDto(item);
			models.add(sliderDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) sliderRepository.count();
	}

	@Override
	@Transactional
	public SliderDTO insert(SliderDTO dto) {
		SliderEntity sliderEntity = sliderConverter.toEntity(dto);
		sliderEntity = sliderRepository.save(sliderEntity);
		return sliderConverter.toDto(sliderEntity);
		
	}
	
	@Override
	@Transactional
	public SliderDTO update(SliderDTO dto) {
		SliderEntity old = sliderRepository.findOne(dto.getId());
		SliderEntity update = sliderConverter.toEntity(old,dto);
		return sliderConverter.toDto(sliderRepository.save(old));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id:ids) {
			sliderRepository.delete(id);
		}
	}

	@Override
	public SliderDTO findById(long id) {
		SliderEntity result = sliderRepository.findOne(id);
		return sliderConverter.toDto(result);
	}

	@Override
	public List<SliderDTO> findAll(Pageable pageable) {
		List<SliderDTO> models= new ArrayList<>();
		List<SliderEntity>entities =  sliderRepository.findAll(pageable).getContent();
		for(SliderEntity item : entities) {
			SliderDTO sliderDTO = sliderConverter.toDto(item);
			models.add(sliderDTO);
		}
		return models;
	}
}
