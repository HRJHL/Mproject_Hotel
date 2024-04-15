package com.service;

import java.util.List;
import com.dao.RoomSDAO;
import com.dto.RoomSDTO;

public interface RoomSService {

	public void setDao(RoomSDAO dao);
	public List<RoomSDTO> find_S();
	public int save_S(RoomSDTO dto);
	public int remove_S(int breakfast_yn);
	public int update_S(RoomSDTO dto);
}