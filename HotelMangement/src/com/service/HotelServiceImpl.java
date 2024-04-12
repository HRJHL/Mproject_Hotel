package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GuestDAO;
import com.dao.RoomDAO;
import com.dto.GuestDTO;
import com.dto.RoomDTO;

public class HotelServiceImpl implements HotelService {

	private RoomDAO roomdao;

	public void setRoomDao(RoomDAO dao) {
		this.roomdao = dao;
	}

	@Override
	public List<RoomDTO> findAllRoom() {
		List<RoomDTO> list = null;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			list = roomdao.findAllRoom(session);
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
	public int saveRoom(RoomDTO dto) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = roomdao.saveRoom(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public int removeByRoomNo(int roomNo) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = roomdao.removeByRoomNo(session, roomNo);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	private GuestDAO guestdao;

	public void setGuestDao(GuestDAO dao) {
		this.guestdao = dao;
	}

	@Override
	public List<GuestDTO> findAllGuest() {
		List<GuestDTO> list = null;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			list = guestdao.findAllGuest(session);
		} finally {
			// session.close();
		}

		for (GuestDTO s : list) {
			int roomNo = s.getRoom_no();
			String guestPno = s.getGuest_pno();
			int mCount = s.getM_count();
			String parkingYn = s.getParking_yn();
			int stayDays = s.getStay_days();
			String guestName = s.getGuest_name();

			System.out.println();
			System.out.println(s);
		}
		return list;
	}

	@Override
	public int saveGuest(GuestDTO dto) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = guestdao.saveGuest(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public int removeByGuestPno(int guestPno) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = guestdao.removeByGuestPno(session, guestPno);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

}
