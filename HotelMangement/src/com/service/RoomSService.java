package com.service;

import java.util.List;

import com.dao.RoomSDAO;
import com.dto.RoomSDTO;

public interface RoomSService {

	public void setDao(RoomSDAO dao);
	public List<RoomSDTO> find();
	//public int save(EmpDTO dto);
	//public int removeByEmpno(int empno);
}