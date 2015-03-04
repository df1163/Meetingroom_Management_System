package com.bfw.service;

import java.util.List;

import com.bfw.domain.EnzhequipmentInfo;

/**
 * 设备信息管理的接口
 * @author Administrator
 *
 */
public interface EnquipmentService {
	
	/**
	 * 添加设备信息
	 * @param info 设备信息
	 * @return true 为成功 false为失败
	 */
	public boolean addEnquipment(EnzhequipmentInfo info);
	
	/**
	 * 查询多个设备信息
	 * @param info
	 * @return
	 */
	public List<EnzhequipmentInfo> getAllEnzhequipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * 根据设备编号查询设别信息
	 * @param enzhequipmentId 设备编号
	 * @return 设备信息
	 */
	public EnzhequipmentInfo getEnzhequipmentInfo(String enzhequipmentId);
	
	/**
	 * 修改设备信息
	 * @param info 内容
	 * @return true 为成功 false为失败
	 */
	public boolean updateEnzhequipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * 根据设备编号删除设备信息
	 * @param enzhequipmentId 设备编号
	 * @return true 为成功 false为失败
	 */
	public boolean deleteEnzhequipmentInfo(String enzhequipmentId);
	
	/**
	 * 查询设备信息
	 * @param info
	 * @return
	 */
	public List<EnzhequipmentInfo> selectEnquipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * 根据编号多表连查 设备信息
	 * @param enzhequipmentId
	 * @return
	 */
	public EnzhequipmentInfo showEnzhequipmentInfo(String enzhequipmentId);
	
	/**
	 * 查询未使用的设备信息
	 * @return
	 */
	public List<EnzhequipmentInfo> queryEnzhequipmentInfo();

}
