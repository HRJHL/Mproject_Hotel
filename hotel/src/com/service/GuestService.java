package com.service;


import com.dao.GuestDAO;
import com.dto.GuestDTO;
import java.util.List;

public interface GuestService {

	public void setDao(GuestDAO dao);
	public List<GuestDTO> find_G();
	public int save_G(GuestDTO dto);
	public int save_P(GuestDTO dto);
	public int remove_G(int guest_pno);
	public int update_G(GuestDTO dto);
}