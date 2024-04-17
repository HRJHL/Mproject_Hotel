package com.dao;



import org.apache.ibatis.session.SqlSession;
import java.util.List;
import com.dto.GuestDTO;

public class GuestDAO {
	
	public List<GuestDTO> find_G(SqlSession session){
		List<GuestDTO> list = 
				session.selectList("com.config.GuestMapper.find_G");
		return list;
	}
	
	//save
	public int save_G(SqlSession session, GuestDTO dto) {
		return session.insert("com.config.GuestMapper.save_G", dto);
	}
	
	public int save_P(SqlSession session, GuestDTO dto) {
		return session.insert("com.config.GuestMapper.save_P", dto);
	}
	
	//remove
	public int remove_G(SqlSession session, String guest_pno) {
		return session.delete("com.config.GuestMapper.remove_G", guest_pno);
	}
	
	//update
	public int update_G(SqlSession session, GuestDTO dto) {
		return session.update("com.config.GuestMapper.update_G", dto);
	}
	public int update_P(SqlSession session, GuestDTO dto) {
		return session.update("com.config.GuestMapper.update_P", dto);
	}
}