package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GuestDAO;
import com.dto.GuestDTO;

public class GuestServiceImpl implements GuestService{

	private GuestDAO dao;
	public void setDao(GuestDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<GuestDTO> findAll() {
	 List<GuestDTO> list = null;	
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

}