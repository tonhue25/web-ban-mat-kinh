package com.webbanmatkinh.converter;

import org.springframework.stereotype.Component;

import com.webbanmatkinh.dto.SliderDTO;
import com.webbanmatkinh.entity.SliderEntity;

@Component
public class SliderConverter {
	
	public SliderDTO toDto(SliderEntity entity) {
		SliderDTO result = new SliderDTO();
		result.setId(entity.getId());
		result.setImage(entity.getImage());
		result.setCaption(entity.getCaption());
		result.setContent(entity.getContent());
		return result;
	}
	
	public SliderEntity toEntity(SliderDTO dto) {
		SliderEntity result = new SliderEntity();
		result.setImage(dto.getImage());
		result.setCaption(dto.getCaption());
		result.setContent(dto.getContent());
		return result;
	}
	
	public SliderEntity toEntity(SliderEntity result,SliderDTO dto) {
		result.setImage(dto.getImage());
		result.setCaption(dto.getCaption());
		result.setContent(dto.getContent());
		return result;
	}
	
}
