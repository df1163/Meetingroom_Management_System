package com.bfw.mapper;

import java.util.List;

import com.bfw.domain.EnzhequipmentInfo;

/**
 * 
 * @author Administrator
 *
 */
public interface EnquipmentMapper {

	
	/**
	 * Add enquipment info
	 * @param info enquipment info
	 * @return 
	 */
	public int addEnquipment(EnzhequipmentInfo info);
	
	/**
	 * Get enquipment info
	 * @param info 
	 * @return multiple equipment information
	 */
	public List<EnzhequipmentInfo> getAllEnzhequipmentInfo(EnzhequipmentInfo info);
	
	
	/**
	 * Get enquipment info by enzhequipmentId
	 * @param enzhequipmentId
	 * @return enzhequipment information
	 */
	public EnzhequipmentInfo getEnzhequipmentInfo(Integer enzhequipmentId);
	
	/**
	 * Update enquipment info
	 * @param enquipment info
	 * @return  
	 */
	public int updateEnzhequipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * 
	 * @param
	 * @return 
	 */
	public int deleteEnzhequipmentInfo(Integer enzhequipmentId);
	
	/**
	 * 
	 * @param info
	 * @return
	 */
	public List<EnzhequipmentInfo> selectEnzhequipmentInfo(EnzhequipmentInfo info);
	
	
	/**
	 * 
	 * @param 
	 * @return
	 */
	public EnzhequipmentInfo showEnquipmentInfo(Integer enzhequipmentId);
	
	
	/**
	 * 
	 * @return
	 */
	public List<EnzhequipmentInfo> queryEnzhequipmentInfo();
}
