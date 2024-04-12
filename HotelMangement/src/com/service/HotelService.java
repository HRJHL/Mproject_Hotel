package com.service;

import java.util.List;

import com.dao.GuestDAO;
import com.dao.RoomDAO;
import com.dto.GuestDTO;
import com.dto.RoomDTO;

public interface HotelService {

	public void setRoomDao(RoomDAO dao);

	public List<RoomDTO> findAllRoom();

	public int saveRoom(RoomDTO dto);

	public int removeByRoomNo(int roomNo);

	public void setGuestDao(GuestDAO dao);

	public List<GuestDTO> findAllGuest();

	public int saveGuest(GuestDTO dto);

	public int removeByGuestPno(int guestPno);
}
