package com.bfw.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bfw.domain.MeetingUserinfo;
import com.bfw.utils.DBFactoryUtils;

public class MeetingUserinfoMapperTest {

	@Test
	public void addMeetingUserinfo() {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {
			MeetingUserinfoMapper mapper = session
					.getMapper(MeetingUserinfoMapper.class);
			MeetingUserinfo meetinguserinfo = new MeetingUserinfo();
			meetinguserinfo.setUserId("admin");
			meetinguserinfo.setBespeakId(1);

			int i = mapper.addMeetingUserinfo(meetinguserinfo);

			if (i > 0) {
				session.commit();

				System.out.println("Ìí¼Ó³É¹¦");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getMeetingUserinfo() {

		try {
			MeetingUserinfoMapper mapper = DBFactoryUtils
					.getMapper(MeetingUserinfoMapper.class);

			MeetingUserinfo meetinguserinfo = new MeetingUserinfo();

			meetinguserinfo.setBespeakId(5);
			;

			List<MeetingUserinfo> list = mapper
					.getAllMeetingUserinfo(meetinguserinfo);
			
			for(MeetingUserinfo mu :list){
				System.out.println(mu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
