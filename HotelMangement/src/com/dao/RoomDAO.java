package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.RoomDTO;

public class RoomDAO {

	public List<RoomDTO> findAll(SqlSession session){
		List<RoomDTO> list = 
				session.selectList("com.config.RoomMapper.All");
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