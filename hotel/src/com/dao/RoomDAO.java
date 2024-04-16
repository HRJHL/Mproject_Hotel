package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.RoomDTO;

public class RoomDAO {

	// select
	public List<RoomDTO> findAllRoom(SqlSession session) {
		List<RoomDTO> list = session.selectList("com.config.RoomMapper.findAllRoom");
		return list;
	}

	// select
	public List<RoomDTO> findRoom_12(SqlSession session) {
		List<RoomDTO> list = session.selectList("com.config.RoomMapper.findRoom_12");
		return list;
	}

	// select
	public List<RoomDTO> findRoom_34(SqlSession session) {
		List<RoomDTO> list = session.selectList("com.config.RoomMapper.findRoom_34");
		return list;
	}

	// select
	public List<RoomDTO> findRoom_56(SqlSession session) {
		List<RoomDTO> list = session.selectList("com.config.RoomMapper.findRoom_56");
		return list;
	}

	public List<RoomDTO> findRoomByCapacity(SqlSession session) {
		List<RoomDTO> list = session.selectList("com.config.RoomMapper.findRoomByCapacity");
		return list;
	}

	// save
	public int save_R(SqlSession session, RoomDTO dto) {
		return session.insert("com.config.RoomMapper.save_R", dto);
	}

	// remove
	public int remove_R(SqlSession session, int room_no) {
		return session.delete("com.config.RoomMapper.remove_R", room_no);
	}

	// update
	public int update_R(SqlSession session, RoomDTO dto) {
		return session.update("com.config.RoomMapper.update_R", dto);
	}
}