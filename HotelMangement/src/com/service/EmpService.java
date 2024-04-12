package com.service;

import java.util.List;

import com.dao.EmpDAO;
import com.dto.EmpDTO;

public interface EmpService {

	public void setDao(EmpDAO dao);
	public List<EmpDTO> findAll();
	public int save(EmpDTO dto);
	public int removeByEmpno(int empno);
}