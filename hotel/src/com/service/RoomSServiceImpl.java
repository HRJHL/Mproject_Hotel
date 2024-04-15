package com.service;



import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.RoomSDAO;
import com.dto.RoomSDTO;

public class RoomSServiceImpl implements RoomSService{

	private RoomSDAO dao;
	public void setDao(RoomSDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<RoomSDTO> find_S() {
	 List<RoomSDTO> list = null;	
	 SqlSession session = null;
      try {
		session = MySqlSessionFactory.getSession();
		//DAO 연동코드
		list = dao.find_S(session);
      }finally {
		session.close();
      }
		return list;
	}
	
	@Override
	public int save_S(RoomSDTO dto) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.getSession();
			//DAO 연동코드
			n = dao.save_S(session, dto);
			session.commit();
	      }finally {
			session.close();
	      }
		return n;
	}
	
	@Override
	public int remove_S(int breakfast_yn) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.getSession();
			//DAO 연동코드
			n = dao.remove_S(session, breakfast_yn);
session.commit();
	      }finally {
			session.close();
	      }
		return n;
	}
	
	@Override
	public int update_S(RoomSDTO dto) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.getSession();
			//DAO 연동코드
			n = dao.update_S(session, dto);
			session.commit();
	      }finally {
			session.close();
	      }
		return n;
	}

}