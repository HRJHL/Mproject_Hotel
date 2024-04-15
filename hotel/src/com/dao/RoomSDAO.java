package com.dao;



import org.apache.ibatis.session.SqlSession;
import java.util.List;
import com.dto.RoomSDTO;

public class RoomSDAO {

	public List<RoomSDTO> find_S(SqlSession session){
		List<RoomSDTO> list = 
				session.selectList("com.config.RoomSMapper.find_S");
		return list;
	}
	//save
	public int save_S(SqlSession session, RoomSDTO dto) {
		return session.insert("com.config.RoomSMapper.save_S", dto);
	}
	//remove
	public int remove_S(SqlSession session, int breakfast_yn) {
		return session.delete("com.config.RoomSMapper.remove_S", breakfast_yn);
	}
	//update
	public int update_S(SqlSession session, RoomSDTO dto) {
		return session.insert("com.config.RoomSMapper.update_S", dto);
	}
}