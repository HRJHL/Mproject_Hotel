package com.service;

import java.util.List;

import com.dao.GuestDAO;
import com.dto.GuestDTO;

public interface GuestService {

	public void setDao(GuestDAO dao);

	public List<GuestDTO> find_G();

	public int save_G(GuestDTO dto);

	public int remove_G(int guest_pno);

	public int update_G(GuestDTO dto);
}