package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.HotelDAO;
import com.dto.HotelDTO;

public class HotelServiceImpl implements HotelService{

	private HotelDAO dao;
	public void setDao(HotelDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<HotelDTO> findAll() {
	 List<HotelDTO> list = null;	
	 SqlSession session = null;
      try {
		session = MySqlSessionFactory.getSession();
		//DAO 연동코드
		list = dao.findAll(session);
      }finally {
		session.close();
      }
		return list;
	}

	@Override
	public int save(HotelDTO dto) {
		int n = 0;
		SqlSession session = null;
	      try {
			session = MySqlSessionFactory.getSession();
			//DAO 연동코드
			n = dao.save(session, dto);
			session.commit();
	      }finally {
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
			//DAO 연동코드
			n = dao.removeByEmpno(session, empno);
session.commit();
	      }finally {
			session.close();
	      }
		return n;
	}

}
