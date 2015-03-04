package com.bfw.service.impl;

import java.util.List;

import com.bfw.domain.MeetingUserinfo;
import com.bfw.mapper.MeetingUserinfoMapper;
import com.bfw.service.MeetingUserinfoService;
import com.bfw.utils.DBFactoryUtils;

public class MeetingUserinfoServiceImpl implements MeetingUserinfoService {

	@Override
	public List<MeetingUserinfo> getAllMeetingUserinfo(
			MeetingUserinfo meetinguserinfo) {

		try {

			MeetingUserinfoMapper mapper = DBFactoryUtils
					.getMapper(MeetingUserinfoMapper.class);
			return mapper.getAllMeetingUserinfo(meetinguserinfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
