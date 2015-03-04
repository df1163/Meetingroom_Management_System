package com.bfw.service;

import java.util.List;

import com.bfw.domain.MeetingroomBespeak;

/**
 * 预约业务逻辑接口
 * @author Administrator
 *
 */
public interface BespeakService {

	/**
	 * 添加预约信息
	 * @param meetbe 预约信息
	 * @param userIds 参加会议人员
	 * @return true 成功 false为失败
	 */
	public boolean addMeetingroomBespeak(MeetingroomBespeak  meetbe,String userIds);
	
	/**
	 * 查询预约会议室信息
	 * @param meetbe 查询条件
	 * @return
	 */
	public List<MeetingroomBespeak> getAllMeetingroomBespeak(MeetingroomBespeak meetbe);
	
	/**
	 * 根据编号查询预约信息
	 * @param bespeakId
	 * @return
	 */
	public MeetingroomBespeak getMeetingroomBespeak(Integer bespeakId);
	
	/**
	 * 修改预约信息
	 * @param meetbe 预约信息
	 * @param userIds 参加会议人员
	 * @return
	 */
	public boolean updateMeetingroomBespeak(MeetingroomBespeak  meetbe,String userIds);
	
	/**
	 * 修改预约信息（预约审核）
	 * @param meetbe 审核信息
	 * @return
	 */
	public boolean updateMeetingroomBespeak(MeetingroomBespeak  meetbe);
	
}
