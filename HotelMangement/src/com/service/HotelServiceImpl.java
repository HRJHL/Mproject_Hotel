package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.RoomDAO;
import com.dto.RoomDTO;

public class HotelServiceImpl implements HotelService {

	private RoomDAO dao;

	public void setDao(RoomDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<RoomDTO> findAllRoom() {
		List<RoomDTO> list = null;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			list = dao.findAllRoom(session);
		} finally {
			// session.close();
		}

		for (RoomDTO s : list) {
			int roomNo = s.getRoom_no();
			int roomState = s.getRoom_state();
			int roomCapacity = s.getRoom_capacity();
			String roomCheckIn = s.getCheckIn();
			String roomCheckOut = s.getCheckOut();

			System.out.println();
			System.out.println(s);
			// System.out.println(
			// roomNo + " " + roomState + " " + roomCapacity + " " + roomCheckIn + " " +
			// roomCheckOut);
		}
		return list;
	}

	@Override
	public int save(RoomDTO dto) {
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
	public int removeByEmpno(int empno) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = dao.removeByRoomNo(session, empno);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

}
