package com.service;


import com.dao.RoomDAO;
import com.dto.RoomDTO;

public interface RoomService {

	public void setDao(RoomDAO dao);
    public int save2(RoomDTO dto);
	//public int removeByEmpno(int empno);
}