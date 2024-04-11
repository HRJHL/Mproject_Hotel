package com.service;

import java.util.List;

import com.dao.RoomDAO;
import com.dto.RoomDTO;

public interface HotelService {

	public void setDao(RoomDAO dao);

	public List<RoomDTO> findAllRoom();

	public int saveRoom(RoomDTO dto);

	public int removeByEmpno(int empno);
}
