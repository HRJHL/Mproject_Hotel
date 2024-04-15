package com.service;



import com.dao.RoomSDAO;
import com.dto.RoomSDTO;

public interface RoomSService {

	public void setDao(RoomSDAO dao);
	public int save3(RoomSDTO dto);
	//public int removeByEmpno(int empno);
}