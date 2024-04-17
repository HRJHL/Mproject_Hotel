package com.dao;

import org.apache.ibatis.session.SqlSession;
import java.util.List;
import com.dto.RoomDTO;

public class RoomDAO {
	
	public List<RoomDTO> find_Q(SqlSession session){
		List<RoomDTO> list = 
				session.selectList("com.config.RoomMapper.find_Q");
		return list;
	}
	
	public List<RoomDTO> find_R12(SqlSession session){
		List<RoomDTO> list = 
				session.selectList("com.config.RoomMapper.find_R12");
		return list;
	}
	public List<RoomDTO> find_S(SqlSession session){
		List<RoomDTO> list = 
				session.selectList("com.config.RoomMapper.find_S");
		return list;
	}
	public List<RoomDTO> find_Empty(SqlSession session) {
	      List<RoomDTO> list = session.selectList("com.config.RoomMapper.find_Empty");
	      return list;
	   }
	public List<RoomDTO> find_R34(SqlSession session){
		List<RoomDTO> list = 
				session.selectList("com.config.RoomMapper.find_R34");
		return list;
	}
	
	public List<RoomDTO> find_R56(SqlSession session){
		List<RoomDTO> list = 
				session.selectList("com.config.RoomMapper.find_R56");
		return list;
	}
	//save
	public int save_R(SqlSession session, RoomDTO dto) {
		return session.insert("com.config.RoomMapper.save_R", dto);
	}
	//remove
	public int remove_R(SqlSession session, int room_no) {
		return session.delete("com.config.RoomMapper.remove_R", room_no);
	}
	
	//update
		public int update_R(SqlSession session, RoomDTO dto) {
			return session.update("com.config.RoomMapper.update_R", dto);
		}
		public int update_St(SqlSession session, RoomDTO dto) {
			return session.update("com.config.RoomMapper.update_St", dto);
		}
}