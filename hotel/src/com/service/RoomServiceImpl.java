package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.RoomDAO;
import com.dto.RoomDTO;

public class RoomServiceImpl implements RoomService {

	private RoomDAO dao;

	public void setDao(RoomDAO dao) {
		this.dao = dao;
	}

	@Override
	public int save2(RoomDTO dto) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = dao.save(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public List<RoomDTO> findAllRoom() {
		List<RoomDTO> list = null;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			list = dao.findAllRoom(session);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<RoomDTO> findRoom_12() {
		List<RoomDTO> list = null;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			list = dao.findRoom_12(session);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

}