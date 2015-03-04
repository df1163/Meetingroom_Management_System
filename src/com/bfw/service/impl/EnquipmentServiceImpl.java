package com.bfw.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bfw.domain.EnzhequipmentInfo;
import com.bfw.mapper.EnquipmentMapper;
import com.bfw.service.EnquipmentService;
import com.bfw.utils.DBFactoryUtils;

public class EnquipmentServiceImpl implements EnquipmentService {

	@Override
	public boolean addEnquipment(EnzhequipmentInfo info) {

		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			EnquipmentMapper mappper = session
					.getMapper(EnquipmentMapper.class);

			int i = mappper.addEnquipment(info);

			if (i > 0) {
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
	public List<EnzhequipmentInfo> getAllEnzhequipmentInfo(
			EnzhequipmentInfo info) {

		try {

			EnquipmentMapper mapper = DBFactoryUtils
					.getMapper(EnquipmentMapper.class);

			if (info != null && info.getEnzhequipmentName() != null
					&& !info.getEnzhequipmentName().equals("")) {

				info.setEnzhequipmentName("%" + info.getEnzhequipmentName()
						+ "%");

			}

			List<EnzhequipmentInfo> list = mapper.getAllEnzhequipmentInfo(info);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public EnzhequipmentInfo getEnzhequipmentInfo(String enzhequipmentId) {
		try {
			EnquipmentMapper mapper = DBFactoryUtils
					.getMapper(EnquipmentMapper.class);

			if (enzhequipmentId != null && !enzhequipmentId.equals("")) {
				return mapper.getEnzhequipmentInfo(Integer
						.valueOf(enzhequipmentId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateEnzhequipmentInfo(EnzhequipmentInfo info) {

		SqlSession session = DBFactoryUtils.getSqlSession();

		try {
			EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);

			EnzhequipmentInfo pinfo = mapper.getEnzhequipmentInfo(info
					.getEnzhequipmentId());

			if (pinfo != null) {

				pinfo.setEnzhequipmentName(info.getEnzhequipmentName());
				pinfo.setEnzhequipmentPrice(info.getEnzhequipmentPrice());
				pinfo.setEnzhequipmentRemerk(info.getEnzhequipmentRemerk());

				int i = mapper.updateEnzhequipmentInfo(pinfo);

				if (i > 0) {
					session.commit();

					return true;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public boolean deleteEnzhequipmentInfo(String enzhequipmentId) {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			if (enzhequipmentId != null && !enzhequipmentId.equals("")) {

				EnquipmentMapper mapper = session
						.getMapper(EnquipmentMapper.class);

				int i = mapper.deleteEnzhequipmentInfo(Integer
						.valueOf(enzhequipmentId));

				if (i > 0) {
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

	@Override
	public List<EnzhequipmentInfo> selectEnquipmentInfo(EnzhequipmentInfo info) {
		try {

			EnquipmentMapper mapper = DBFactoryUtils
					.getMapper(EnquipmentMapper.class);

			if (info != null && info.getEnzhequipmentName() != null
					&& !info.getEnzhequipmentName().equals("")) {

				info.setEnzhequipmentName("%" + info.getEnzhequipmentName()
						+ "%");

			}

			List<EnzhequipmentInfo> list = mapper.selectEnzhequipmentInfo(info);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EnzhequipmentInfo showEnzhequipmentInfo(String enzhequipmentId) {

		try {
			EnquipmentMapper mapper = DBFactoryUtils
					.getMapper(EnquipmentMapper.class);

			if (enzhequipmentId != null && !enzhequipmentId.equals("")) {
				EnzhequipmentInfo eninfo = mapper.showEnquipmentInfo(Integer
						.valueOf(enzhequipmentId));

				return eninfo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<EnzhequipmentInfo> queryEnzhequipmentInfo() {
		try {
			EnquipmentMapper mapper = DBFactoryUtils
					.getMapper(EnquipmentMapper.class);
			return mapper.queryEnzhequipmentInfo();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
