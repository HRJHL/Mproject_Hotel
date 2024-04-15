package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GuestDTO;

public class GuestDAO {

	// save
	public int save(SqlSession session, GuestDTO dto) {
		return session.insert("com.config.GuestMapper.save", dto);
	}

	// select
	public List<GuestDTO> findAllGuest(SqlSession session) {
		List<GuestDTO> list = session.selectList("com.config.HotelMapper.findAllGuest");
		return list;
	}

	public List<GuestDTO> findGuestByPno(SqlSession session) {
		List<GuestDTO> list = session.selectList("com.config.HotelMapper.findAllGuest");
		return list;
	}

	// save
	public int saveGuest(SqlSession session, GuestDTO dto) {
		return session.insert("com.config.HotelMapper.saveGuest", dto);
	}

	// remove
	public int removeByGuestPno(SqlSession session, int roomNo) {
		return session.delete("com.config.HotelMapper.removeByGuestPno", roomNo);
	}
}