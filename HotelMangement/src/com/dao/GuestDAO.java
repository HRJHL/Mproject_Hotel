package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GuestDTO;

public class GuestDAO {

	public List<GuestDTO> findAll(SqlSession session){
		List<GuestDTO> list = 
				session.selectList("com.config.GuestMapper.findAll");
		return list;
	}
	//save
	//public int save(SqlSession session, EmpDTO dto) {
	//	return session.insert("com.config.EmpMapper.save", dto);
	//}
	//remove
	//public int removeByEmpno(SqlSession session, int empno) {
	//	return session.delete("com.config.EmpMapper.removeByEmpno", empno);
	//}
}