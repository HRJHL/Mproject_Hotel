package com.service;

import java.util.List;

import com.dao.GuestDAO;
import com.dto.GuestDTO;

public interface GuestService {

	public void setDao(GuestDAO dao);
	public List<GuestDTO> findAll();
	//public int save(EmpDTO dto);
	//public int removeByEmpno(int empno);
}