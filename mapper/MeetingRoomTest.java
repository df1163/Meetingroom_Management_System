package com.bfw.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bfw.domain.MeetingRoom;
import com.bfw.utils.DBFactoryUtils;

public class MeetingRoomTest {

	@Test
	public void getAllMeetingroom(){
		
		try {
			MeetingRoomMapper mapper =DBFactoryUtils.getMapper(MeetingRoomMapper.class);
			List<MeetingRoom> list = mapper.getAllMeetingRoom(null);
			
			for(MeetingRoom meeringroom:list){
				System.out.println(meeringroom);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void getMeetingRoom(){
		
		try {
			
			MeetingRoomMapper mapper = DBFactoryUtils.getMapper(MeetingRoomMapper.class);
			MeetingRoom meetingroom = mapper.getMeetingRoom(1);
			System.out.println(meetingroom);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateMeetingRoom(){
		
		SqlSession session = DBFactoryUtils.getSqlSession();
		try {
			MeetingRoomMapper mapper = session.getMapper(MeetingRoomMapper.class);
			
			MeetingRoom mr = new MeetingRoom();
			mr.setMeetingroomId(22);
			mr.setMeetingroomName("公共会议室");
			mr.setMeetingroomSize("200");
			mr.setMeetingroomNote("很多人");
			
			int i = mapper.updateMeetingRoom(mr);
			
			if(i>0){
				session.commit();
				System.out.println("修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
}
