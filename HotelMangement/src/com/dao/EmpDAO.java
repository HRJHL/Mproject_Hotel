package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.EmpDTO;

public class EmpDAO {

	public List<EmpDTO> findAll(SqlSession session){
		List<EmpDTO> list = 
				session.selectList("com.config.EmpMapper.findAll");
		return list;
	}
	//save
	public int save(SqlSession session, EmpDTO dto) {
		return session.insert("com.config.EmpMapper.save", dto);
	}
	//remove
	public int removeByEmpno(SqlSession session, int empno) {
		return session.delete("com.config.EmpMapper.removeByEmpno", empno);
	}
}