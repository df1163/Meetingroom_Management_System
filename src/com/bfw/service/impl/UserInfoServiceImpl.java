package com.bfw.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bfw.domain.UserInfo;
import com.bfw.mapper.UserInfoMapper;
import com.bfw.service.UserInfoService;
import com.bfw.utils.DBFactoryUtils;

public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public UserInfo isLogin(String userId, String passWord) {
		// 数据访问对象
		UserInfoMapper mapper = DBFactoryUtils.getMapper(UserInfoMapper.class);
		try {
			if (userId != null && passWord != null) {
				UserInfo user = new UserInfo();
				user.setUserId(userId);
				user.setUserPw(passWord);

				return mapper.getUser(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean add(UserInfo userinfo) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		try {
			UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
			if (userinfo != null && userinfo.getUserId() != null
					&& userinfo.getUserPw() != null) {

				int i = mapper.addUser(userinfo);
				session.commit();
				if (i > 0) {
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
	public List<UserInfo> getAllUser(UserInfo user) {

		try {

			UserInfoMapper mapper = DBFactoryUtils
					.getMapper(UserInfoMapper.class);

			if (user != null && user.getUserName() != null
					&& !user.getUserName().equals("")) {
				user.setUserName("%" + user.getUserName() + "%");
			}

			List<UserInfo> list = mapper.getAllUser(user);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserInfo getUser(String userId) {

		try {
			if (userId != null && !userId.equals("")) {
				UserInfoMapper mapper = DBFactoryUtils
						.getMapper(UserInfoMapper.class);

				return mapper.getUserInfo(userId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateUser(UserInfo user) {

		SqlSession session = DBFactoryUtils.getSqlSession();
		try {
			UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);

			UserInfo userinfo = mapper.getUserInfo(user.getUserId());

			if (userinfo != null) {
				userinfo.setUserName(user.getUserName());
				userinfo.setUserPw(user.getUserPw());
				userinfo.setUserSex(user.getUserSex());
				userinfo.setUserAge(user.getUserAge());
				userinfo.setUserPhone(user.getUserPhone());

				if (user.getUserUrl() != null) {
					userinfo.setUserUrl(user.getUserUrl());
				}
				userinfo.setUserBeizhu(user.getUserBeizhu());

				int i = mapper.updateUser(userinfo);
				if (i > 0) {
					session.commit();
					return true;
				}

			}

			//

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		try {
			
			UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
			
			UserInfo user = mapper.getUserInfo(userId);
			
			if(user!=null){
				//0无效
				user.setIsUsed("0");
				
				int i = mapper.updateUser(user);
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

	@Override
	public boolean anthorityChange(UserInfo user) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		try {
			UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);

			UserInfo userinfo = mapper.getUserInfo(user.getUserId());

			if (userinfo != null) {
				//变更权限
				userinfo.setUserAnthority(user.getUserAnthority());

				int i = mapper.updateUser(userinfo);
				if (i > 0) {
					session.commit();
					return true;
				}

			}

			//

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return false;
	}

}
