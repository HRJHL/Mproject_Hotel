package com.service;

import java.util.List;

import com.dao.RoomDAO;
import com.dto.RoomDTO;

public interface RoomService {

	public void setDao(RoomDAO dao);

	public int save2(RoomDTO dto);

	public List<RoomDTO> findAllRoom();
	// public int removeByEmpno(int empno);
}