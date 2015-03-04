package com.bfw.mapper;

import java.util.List;

import com.bfw.domain.UserInfo;

public interface UserInfoMapper {


	/**
	 * 根据条件查询用户信息
	 * @param user 查询条件
	 * @return 用户信息
	 */
	public UserInfo getUser(UserInfo user);
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public int addUser(UserInfo user);
	
	/**
	 * 查询多个用户信息
	 * @param user 用户信息
	 * @return 多个用户信息
	 */
	public List<UserInfo> getAllUser(UserInfo user);
	
	/**
	 * 根据编号查询用户信息
	 * @param userId 用户编号
	 * @return 单个用户信息
	 */
	public UserInfo getUserInfo(String userId);
	
	/**
	 * 修改用户信息
	 * @param user 修改的内容
	 * @return 返回影响的行数
	 */
	public int updateUser(UserInfo user);
	
/*	*//**
	 * 根据 userId删除用户信息
	 * @param userId 账号
	 * @return 返回影响的行数
	 *//*
	public int deleteUser(String userId);*/
	
}
