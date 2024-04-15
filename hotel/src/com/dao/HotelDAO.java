package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.HotelDTO;

public class HotelDAO {

	// select
	public HotelDTO findPasswd(SqlSession session) {
		HotelDTO passwd = session.selectOne("com.config.HotelMapper.findPasswd");
		return passwd;
	}

	// update
	public int updatePasswd(SqlSession session, String passwd) {
		return session.update("com.config.HotelMapper.updatePasswd", passwd);
	}

}