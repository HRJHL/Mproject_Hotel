package com.service;

import java.util.List;
import com.dao.RoomDAO;
import com.dto.RoomDTO;

public interface RoomService {

	public void setDao(RoomDAO dao);
	public List<RoomDTO> find_Q();
	public List<RoomDTO> find_S();
	public List<RoomDTO> find_R12();
	public List<RoomDTO> find_R34();
	public List<RoomDTO> find_R56();
    public int save_R(RoomDTO dto);
	public int remove_R(int room_no);
	public int update_R(RoomDTO dto);
	public int update_St(RoomDTO dto);
	public List<RoomDTO> find_Empty();
}