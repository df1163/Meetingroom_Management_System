package com.bfw.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bfw.domain.EnzhequipmentInfo;
import com.bfw.utils.DBFactoryUtils;

public class EnquipmentMapperTest {

	@Test
	public void add() {

		SqlSession session = DBFactoryUtils.getSqlSession();

		try {
			EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);
			EnzhequipmentInfo info = new EnzhequipmentInfo();
			info.setUserId("admin");
			info.setEnzhequipmentName("投影仪");
			info.setEnzhequipmentPrice(3999.00);
			info.setProcurementTime(new Date());
			info.setEnzhequipmentRemerk("这个投影仪很好用");

			int i = mapper.addEnquipment(info);
			if (i > 0) {
				System.out.println("添加成功");
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}

	}

	@Test
	public void queryAll() {

		EnquipmentMapper mapper = DBFactoryUtils
				.getMapper(EnquipmentMapper.class);

		EnzhequipmentInfo info = new EnzhequipmentInfo();

		info.setEnzhequipmentName("%投%");

		List<EnzhequipmentInfo> list = mapper.getAllEnzhequipmentInfo(info);

		for (EnzhequipmentInfo enzheinfo : list) {
			System.out.println(enzheinfo);
		}

	}
	
	@Test
	public void selectAll() {

		EnquipmentMapper mapper = DBFactoryUtils
				.getMapper(EnquipmentMapper.class);



		List<EnzhequipmentInfo> list = mapper.selectEnzhequipmentInfo(null);

		for (EnzhequipmentInfo enzheinfo : list) {
			System.out.println(enzheinfo);
		}

	}

	@Test
	public void update() {
		SqlSession session = DBFactoryUtils.getSqlSession();
		try {
			EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);
			EnzhequipmentInfo info = new EnzhequipmentInfo();
			info.setEnzhequipmentId(3);
			info.setUserId("admin");
			info.setEnzhequipmentName("投影仪");
			info.setEnzhequipmentPrice(3999.00);
			info.setProcurementTime(new Date());
			info.setEnzhequipmentRemerk("这个投影仪很好用");

			int i = mapper.updateEnzhequipmentInfo(info);
			if (i > 0) {
				System.out.println("修改成功");
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}

	}

	@Test
	public void getEninfo() {

		try {
			EnquipmentMapper mapper = DBFactoryUtils
					.getMapper(EnquipmentMapper.class);

			EnzhequipmentInfo info = mapper.getEnzhequipmentInfo(1);
			System.out.println(info);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void delete() {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);

			int i = mapper.deleteEnzhequipmentInfo(1);
			
			if(i>0){
				session.commit();
				
				System.out.println("删除成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
