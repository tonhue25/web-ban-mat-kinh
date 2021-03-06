package com.webbanmatkinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanmatkinh.converter.BillConverter;
import com.webbanmatkinh.dto.BillDTO;
import com.webbanmatkinh.entity.BillEntity;
import com.webbanmatkinh.repository.BillRepository;
import com.webbanmatkinh.service.IBillService;

@Service
public class BillService implements IBillService{
	
	@Autowired
	private BillConverter billConverter;
	
	@Autowired
	private BillRepository billRepository;
	
	@Override
	@Transactional
	public BillDTO insert(BillDTO dto) {
		BillEntity entity = billConverter.toEntity(dto);
		entity = billRepository.save(entity);
		return billConverter.toDto(entity);
	}
	
	@Override
	public List<BillEntity> findByUser_id(Long userId) {
		return billRepository.findByUser_id(userId);
	}
	
	@Override
	public List<BillDTO> findAllByUser_id(Long userId) {
		List<BillDTO> models = new ArrayList<>();
		List<BillEntity> entities = findByUser_id(userId);
		for (BillEntity item : entities) {
			BillDTO dto = billConverter.toDto(item);
			models.add(dto);
		}
		return models;
	}
	
}
