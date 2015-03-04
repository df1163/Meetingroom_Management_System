package com.bfw.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bfw.domain.UserInfo;
import com.bfw.utils.DBFactoryUtils;

public class UserInfoMapperTest {

	@Test
	public void getAllUser() {

		UserInfoMapper mapper = DBFactoryUtils.getMapper(UserInfoMapper.class);

		UserInfo user = new UserInfo();
		user.setUserName("张三");
		user.setUserSex("男");

		List<UserInfo> list = mapper.getAllUser(user);

		for (UserInfo userinfo : list) {
			System.out.println(userinfo);
		}

	}

	@Test
	public void getUserInfo() {

		UserInfoMapper mapper = DBFactoryUtils.getMapper(UserInfoMapper.class);

		UserInfo user = mapper.getUserInfo("admin");
		System.out.println(user);

	}

	@Test
	public void updateUser() {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);

			UserInfo userInfo = new UserInfo();
			userInfo.setUserId("243");
			userInfo.setUserName("张伟");
			userInfo.setUserSex("男");
			userInfo.setUserAge(17);
			

			int i = mapper.updateUser(userInfo);
			
			if(i>0){
				session.commit();
				System.out.println("修改成功！");
			}else{
				System.out.println("修改失败");
			}

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}

	}
	
	@Test
	public void delete(){
		
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);

			
/*
			int i = mapper.deleteUser("admin");
			
			if(i>0){
				session.commit();
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败");
			}*/

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
	}

}
