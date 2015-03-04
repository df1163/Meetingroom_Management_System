package com.bfw.mapper;

import java.util.List;

import com.bfw.domain.MeetingRoom;

/**
 * 会议室的数据访问接口
 * @author Administrator
 *
 */
public interface MeetingRoomMapper {
	
	/**
	 * 查询会议室信息
	 * @param meetroom 查询条件
	 * @return 返回有效会议室（多个）
	 */
	public List<MeetingRoom> getAllMeetingRoom(MeetingRoom meetroom);

	/**
	 * 添加会议室信息
	 * @param meetroom 会议室信息
	 * @return 返回影响行数
	 */
	public int addMeetingRoom(MeetingRoom meetroom);
	
	/**
	 * 根据编号查询会议室信息
	 * @param meetingroomId 会议室编号
	 * @return
	 */
	public MeetingRoom getMeetingRoom(Integer meetingroomId); 
	
	/**
	 * 修改会议室信息
	 * @param meetroom 会议室信息
	 * @return 返回影响的行数
	 */
	public int updateMeetingRoom(MeetingRoom meetroom);
	
}
