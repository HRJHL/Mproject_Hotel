package com.dao;



import org.apache.ibatis.session.SqlSession;

import com.dto.GuestDTO;

public class GuestDAO {

	
	//save
	public int save(SqlSession session, GuestDTO dto) {
		return session.insert("com.config.GuestMapper.save", dto);
	}
	//remove
	//public int removeByEmpno(SqlSession session, int empno) {
	//	return session.delete("com.config.EmpMapper.removeByEmpno", empno);
	//}
}