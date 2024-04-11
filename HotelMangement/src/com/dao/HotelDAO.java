package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.HotelDTO;

public class HotelDAO {

	public List<HotelDTO> findAll(SqlSession session) {
		List<HotelDTO> list = session.selectList("com.config.HotelMapper.findAll");
		return list;
	}

	// save
	public int save(SqlSession session, HotelDTO dto) {
		return session.insert("com.config.HotelMapper.save", dto);
	}

	// remove
	public int removeByEmpno(SqlSession session, int empno) {
		return session.delete("com.config.HotelMapper.removeByEmpno", empno);
	}
}
