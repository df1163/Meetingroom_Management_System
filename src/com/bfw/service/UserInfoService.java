package com.bfw.service;

import java.util.List;

import com.bfw.domain.UserInfo;

/**
 * 用户信息的业务逻辑接口
 * @author Administrator
 *
 */
public interface UserInfoService {
	
	/**
	 * 用户登录
	 * @param userId 账号
	 * @param passWord 密码
	 * @return 用户信息
	 */
	public UserInfo isLogin(String userId,String passWord);
	
	/**
	 * 添加用户信息
	 * @param userinfo
	 * @return
	 */
	public boolean add(UserInfo userinfo);
	
	/**
	 * 查询用户信息
	 * @param user 查询条件
	 * @return 多个用户信息
	 */
	public List<UserInfo> getAllUser(UserInfo user);
	
	/**
	 * 根据账号查询用户信息
	 * @param userId 账号
	 * @return 用户信息
	 */
	public UserInfo getUser(String userId);
	
	/**
	 * 修改用户信息
	 * @param user 修改内容
	 * @return true成功 false失败 
	 */
	public boolean updateUser(UserInfo user);
	
	/**
	 * 根据userId删除用户信息
	 * @param userId 账号
	 * @return true为成功 false为失败
	 */
	public boolean deleteUser(String userId);
	
	/**
	 * 变更权限
	 * @param user 用户信息
	 * @return true为成功 false为失败
	 */
	public boolean anthorityChange(UserInfo user);

}
