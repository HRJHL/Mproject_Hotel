package com.service;



import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.RoomDAO;
import com.dto.RoomDTO;

public class RoomServiceImpl implements RoomService{

	private RoomDAO dao;
	public void setDao(RoomDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<RoomDTO> find_R() {
	 List<RoomDTO> list = null;	
	 SqlSession session = null;
      try {
		session = MySqlSessionFactory.getSession();
		//DAO 연동코드
		list = dao.find_R(session);
      }finally {
		session.close();
      }
		return list;
	}
	
	@Override
	public int save_R(RoomDTO dto) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.getSession();
			//DAO 연동코드
			n = dao.save_R(session, dto);
			session.commit();
	      }finally {
			session.close();
	      }
		return n;
	}
	
	@Override
	public int remove_R(int room_no) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.getSession();
			//DAO 연동코드
			n = dao.remove_R(session, room_no);
session.commit();
	      }finally {
			session.close();
	      }
		return n;
	}
	
	@Override
	public int update_R(RoomDTO dto) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.getSession();
			//DAO 연동코드
			n = dao.update_R(session, dto);
			session.commit();
	      }finally {
			session.close();
	      }
		return n;
	}

}