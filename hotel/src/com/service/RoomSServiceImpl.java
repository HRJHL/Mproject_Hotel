package com.service;



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
	public int save3(RoomSDTO dto) {
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

}