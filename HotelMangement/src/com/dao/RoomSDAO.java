package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.RoomSDTO;

public class RoomSDAO {

	public List<RoomSDTO> findAll(SqlSession session){
		List<RoomSDTO> list = 
				session.selectList("com.config.RoomSMapper.find");
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