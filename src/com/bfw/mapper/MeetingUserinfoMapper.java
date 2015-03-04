package com.bfw.mapper;

import java.util.List;

import com.bfw.domain.MeetingUserinfo;

/**
 * 
 * @author Administrator
 *
 */
public interface MeetingUserinfoMapper {

	/**
	 * 
	 * @param meetinguserinfo
	 * @return 
	 */
	public int addMeetingUserinfo(MeetingUserinfo meetinguserinfo);
	
	/**
	 * 
	 * @param meetinguserinfo 
	 * @return
	 */
	public List<MeetingUserinfo> getAllMeetingUserinfo(MeetingUserinfo meetinguserinfo);
}
