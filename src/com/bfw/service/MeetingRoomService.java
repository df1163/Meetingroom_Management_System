package com.bfw.service;

import java.util.List;

import com.bfw.domain.MeetingRoom;

/**
 * 会议室信息管理的业务逻辑接口
 * @author Administrator
 *
 */
public interface MeetingRoomService {
	
	/**
	 * 查询会议室信息
	 * @param meetingroom 查询条件
	 * @return 返回多个会议室信息
	 */
	public List<MeetingRoom> getAllMeetingRoooms(MeetingRoom meetingroom);
	
	/**
	 * 添加会议室信息
	 * @param meetingroom 会议室信息
	 * @param enzhequipmentIds 会议室设备信息
	 * @return true 成功 false失败
	 */
	public boolean addMeetingRoom(MeetingRoom meetingroom,String enzhequipmentIds);
	
	/**
	 * 根据编号查询会议室信息
	 * @param meetingroomId 会议室编号
	 * @return
	 */
	public MeetingRoom getMeetingRoom(String meetingroomId);
	
	/**
	 * 修改会议室信息
	 * @param meetingroom 会议室信息
	 * @param enzhequipmentIds 设备编号
	 * @return true成功 false 失败
	 */
	public boolean updatemeetingRoom(MeetingRoom meetingroom,String enzhequipmentIds);
	
	/**
	 * 更具编号删除会议室信息
	 * @param meetingroomId 会议室编号
	 * @return
	 */
	public boolean deleteMeetingRoom(String meetingroomId);

}
