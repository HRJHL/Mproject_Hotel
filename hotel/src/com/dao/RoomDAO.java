package com.dao;

import org.apache.ibatis.session.SqlSession;
import java.util.List;
import com.dto.RoomDTO;

public class RoomDAO {
	
	public List<RoomDTO> find_R(SqlSession session){
		List<RoomDTO> list = 
				session.selectList("com.config.RoomMapper.find_R");
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
			return session.insert("com.config.RoomMapper.update_R", dto);
		}
}