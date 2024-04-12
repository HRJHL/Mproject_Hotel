package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GuestDTO;

public class GuestDAO {

	// select
	public List<GuestDTO> findAllGuest(SqlSession session) {
		List<GuestDTO> list = session.selectList("com.config.HotelMapper.findAllRoom");
		return list;
	}

	// save
	public int saveGuest(SqlSession session, GuestDTO dto) {
		return session.insert("com.config.HotelMapper.saveRoom", dto);
	}

	// remove
	public int removeByGuestPno(SqlSession session, int roomNo) {
		return session.delete("com.config.HotelMapper.removeByRoomNo", roomNo);
	}
}