package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.RoomDTO;

public class RoomDAO {

	// select
	public List<RoomDTO> findAllRoom(SqlSession session) {
		List<RoomDTO> list = session.selectList("com.config.HotelMapper.findAllRoom");
		return list;
	}

	// save
	public int save(SqlSession session, RoomDTO dto) {
		return session.insert("com.config.HotelMapper.save", dto);
	}

	// remove
	public int removeByRoomNo(SqlSession session, int roomNo) {
		return session.delete("com.config.HotelMapper.removeByRoomNo", roomNo);
	}
}