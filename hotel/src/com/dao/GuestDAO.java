package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GuestDTO;

public class GuestDAO {

	public List<GuestDTO> find_G(SqlSession session) {
		List<GuestDTO> list = session.selectList("com.config.GuestMapper.find_G");
		return list;
	}

	// save
	public int save_G(SqlSession session, GuestDTO dto) {
		return session.insert("com.config.GuestMapper.save_G", dto);
	}

	// remove
	public int remove_G(SqlSession session, int guest_pno) {
		return session.delete("com.config.GuestMapper.remove_G", guest_pno);
	}

	// update
	public int update_G(SqlSession session, GuestDTO dto) {
		return session.update("com.config.GuestMapper.update_G", dto);
	}
}