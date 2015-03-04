package com.bfw.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bfw.domain.EnzhequipmentInfo;
import com.bfw.domain.MeetingRoom;
import com.bfw.mapper.EnquipmentMapper;
import com.bfw.mapper.MeetingRoomMapper;
import com.bfw.service.MeetingRoomService;
import com.bfw.utils.DBFactoryUtils;

public class MeetingRoomServiceImpl implements MeetingRoomService {

	@Override
	public List<MeetingRoom> getAllMeetingRoooms(MeetingRoom meetingroom) {

		try {
			MeetingRoomMapper mapper = DBFactoryUtils
					.getMapper(MeetingRoomMapper.class);

			if (meetingroom != null && meetingroom.getMeetingroomName() != null
					&& !meetingroom.getMeetingroomName().equals("")) {
				meetingroom.setMeetingroomName("%"
						+ meetingroom.getMeetingroomName() + "%");
			}

			List<MeetingRoom> list = mapper.getAllMeetingRoom(meetingroom);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addMeetingRoom(MeetingRoom meetingroom,
			String enzhequipmentIds) {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			// 会议室
			MeetingRoomMapper meetmapper = session
					.getMapper(MeetingRoomMapper.class);

			int i = meetmapper.addMeetingRoom(meetingroom);
			int x = -1;
			// 设备信息
			EnquipmentMapper enmapper = session
					.getMapper(EnquipmentMapper.class);
			// 修改设备信息
			String[] enzhequipmentId = enzhequipmentIds.split(",");
			for (int a = 0; a < enzhequipmentId.length; a++) {

				EnzhequipmentInfo enfinfo = enmapper
						.getEnzhequipmentInfo(Integer
								.parseInt(enzhequipmentId[a]));

				if (enfinfo != null) {
					enfinfo.setMeetingroomId(meetingroom.getMeetingroomId());
					x = enmapper.updateEnzhequipmentInfo(enfinfo);
				}

			}

			if (i > 0 && x > 0) {
				session.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}

		return false;
	}

	@Override
	public MeetingRoom getMeetingRoom(String meetingroomId) {

		try {
			MeetingRoomMapper mapper = DBFactoryUtils
					.getMapper(MeetingRoomMapper.class);
			if (meetingroomId != null && !meetingroomId.equals("")) {
				return mapper.getMeetingRoom(Integer.parseInt(meetingroomId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updatemeetingRoom(MeetingRoom meetingroom,
			String enzhequipmentIds) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		try {

			MeetingRoomMapper mapper = session
					.getMapper(MeetingRoomMapper.class);

			MeetingRoom mr = mapper.getMeetingRoom(meetingroom
					.getMeetingroomId());

			if (mr != null) {
				mr.setMeetingroomName(meetingroom.getMeetingroomName());
				mr.setMeetingroomSize(meetingroom.getMeetingroomSize());
				mr.setMeetingroomNote(meetingroom.getMeetingroomNote());

				int i = mapper.updateMeetingRoom(mr);

				// 判断设备编号是否为空
				if (enzhequipmentIds != null && !enzhequipmentIds.equals("")) {
					int x = -1;
					// 设备信息
					EnquipmentMapper enmapper = session
							.getMapper(EnquipmentMapper.class);
					// 修改设备信息
					String[] enzhequipmentId = enzhequipmentIds.split(",");
					for (int a = 0; a < enzhequipmentId.length; a++) {

						EnzhequipmentInfo enfinfo = enmapper
								.getEnzhequipmentInfo(Integer
										.parseInt(enzhequipmentId[a]));

						if (enfinfo != null) {
							enfinfo.setMeetingroomId(meetingroom
									.getMeetingroomId());
							x = enmapper.updateEnzhequipmentInfo(enfinfo);

							if (x == 0) {
								break;
							}
						}

					}

					if (i > 0 && x > 0) {
						session.commit();
						return true;
					} else {
						return false;
					}

				} else {

					if (i > 0) {
						session.commit();
						return true;
					} else {
						return false;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}

		return false;
	}

	@Override
	public boolean deleteMeetingRoom(String meetingroomId) {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {
			// 会议室数据访问接口
			MeetingRoomMapper mapper = session
					.getMapper(MeetingRoomMapper.class);

			MeetingRoom mr = mapper.getMeetingRoom(Integer
					.parseInt(meetingroomId));
			if (mr != null) {
				mr.setMeetingroomState("0");

				int i = mapper.updateMeetingRoom(mr);

				//查询会议室相关设备信息
				EnquipmentMapper enmapper = session
						.getMapper(EnquipmentMapper.class);
				EnzhequipmentInfo info = new EnzhequipmentInfo();
				info.setMeetingroomId(mr.getMeetingroomId());
				List<EnzhequipmentInfo> enlist = enmapper.selectEnzhequipmentInfo(info);
				
				for(EnzhequipmentInfo enqui:enlist){
					enqui.setMeetingroomId(null);
					enmapper.updateEnzhequipmentInfo(enqui);
				}
				
				if(i>0){
					session.commit();
					return true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;
	}

}
