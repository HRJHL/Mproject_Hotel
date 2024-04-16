package com.service;

import java.util.List;

import com.dao.RoomDAO;
import com.dto.RoomDTO;

public interface RoomService {

	public void setDao(RoomDAO dao);

	public List<RoomDTO> findAllRoom();

	public List<RoomDTO> findRoom_12();

	public List<RoomDTO> findRoom_34();

	public List<RoomDTO> findRoom_56();

	public int save_R(RoomDTO dto);

	public int remove_R(int room_no);

	public int update_R(RoomDTO dto);
}