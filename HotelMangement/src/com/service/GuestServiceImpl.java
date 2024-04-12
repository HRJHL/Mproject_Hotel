package com.service;



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
	public int save(GuestDTO dto) {
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