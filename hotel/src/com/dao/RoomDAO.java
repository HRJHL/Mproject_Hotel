package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.RoomDTO;

public class RoomDAO {

	//save
	public int save(SqlSession session, RoomDTO dto) {
		return session.insert("com.config.RoomMapper.save2", dto);
	}
	//remove
	//public int removeByEmpno(SqlSession session, int empno) {
	//	return session.delete("com.config.EmpMapper.removeByEmpno", empno);
	//}
}