package com.service;

import java.util.List;
import com.dao.RoomDAO;
import com.dto.RoomDTO;

public interface RoomService {

	public void setDao(RoomDAO dao);
	public List<RoomDTO> find_R();
    public int save_R(RoomDTO dto);
	public int remove_R(int room_no);
	public int update_R(RoomDTO dto);
}