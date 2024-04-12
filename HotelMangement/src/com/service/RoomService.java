package com.service;

import java.util.List;

import com.dao.RoomDAO;
import com.dto.RoomDTO;

public interface RoomService {

	public void setDao(RoomDAO dao);
	public List<RoomDTO> All();
	//public int save(EmpDTO dto);
	//public int removeByEmpno(int empno);
}