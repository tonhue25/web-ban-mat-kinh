package com.webbanmatkinh.service;

import java.util.List;

import com.webbanmatkinh.dto.BillDTO;
import com.webbanmatkinh.entity.BillEntity;

public interface IBillService {

	BillDTO insert(BillDTO dto);

	List<BillEntity> findByUser_id(Long userId);

	List<BillDTO> findAllByUser_id(Long userId);
}
