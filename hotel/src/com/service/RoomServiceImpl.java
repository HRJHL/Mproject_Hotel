package com.service;



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
	public int save2(RoomDTO dto) {
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