package com.dao;



import org.apache.ibatis.session.SqlSession;

import com.dto.RoomSDTO;

public class RoomSDAO {

	
	//save
	public int save(SqlSession session, RoomSDTO dto) {
		return session.insert("com.config.RoomSMapper.save3", dto);
	}
	//remove
	//public int removeByEmpno(SqlSession session, int empno) {
	//	return session.delete("com.config.EmpMapper.removeByEmpno", empno);
	//}
}