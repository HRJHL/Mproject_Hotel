package com.service;


import com.dao.GuestDAO;
import com.dto.GuestDTO;

public interface GuestService {

	public void setDao(GuestDAO dao);
	
	public int save(GuestDTO dto);
	//public int removeByEmpno(int empno);
}