package com.bfw.service;

import java.util.List;

import com.bfw.domain.MeetingUserinfo;

/**
 * 参加会议人员关系表 业务逻辑接口
 * @author Administrator
 *
 */
public interface MeetingUserinfoService {

	/**
	 * 根据调价查询参加会议人员信息
	 * @param meetinguserinfo 查询条件
	 * @return
	 */
	public List<MeetingUserinfo> getAllMeetingUserinfo(MeetingUserinfo meetinguserinfo);
}
