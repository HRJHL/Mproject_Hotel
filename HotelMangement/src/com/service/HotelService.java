package com.service;

import java.util.List;

import com.dao.HotelDAO;
import com.dto.HotelDTO;

public interface HotelService {

	public void setDao(HotelDAO dao);
	public List<HotelDTO> findAll();
	public int save(HotelDTO dto);
	public int removeByEmpno(int empno);
}
