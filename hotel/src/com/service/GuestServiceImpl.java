package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GuestDAO;
import com.dto.GuestDTO;

public class GuestServiceImpl implements GuestService {

	private GuestDAO dao;

	public void setDao(GuestDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<GuestDTO> find_G() {
		List<GuestDTO> list = null;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			list = dao.find_G(session);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int save_G(GuestDTO dto) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = dao.save_G(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public int remove_G(int guest_pno) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = dao.remove_G(session, guest_pno);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	public int update_G(GuestDTO dto) {
		int n = 0;
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSession();
			// DAO 연동코드
			n = dao.update_G(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

}