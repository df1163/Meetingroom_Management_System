package com.bfw.mapper;

import java.util.List;

import com.bfw.domain.MeetingroomBespeak;

/**
 * 
 * @author Administrator
 *
 */
public interface MeetingroomBespeakMapper {
	
	/**
	 * 
	 * @param bespeak 
	 * @return
	 */
	public  int addBespeak(MeetingroomBespeak bespeak );
	
	/**
	 * 
	 * @param bespeak
	 * @return 
	 */
	public List<MeetingroomBespeak> getAllMeetingroomBespeak(MeetingroomBespeak bespeak);


	/**
	 * 
	 * @param bespeakId 
	 * @return 
	 */
	public MeetingroomBespeak getMeetingroomBespeak(Integer bespeakId);
	
	
	/**
	 * 
	 * @param bespeak
	 * @return
	 */
	public  int updateBespeak(MeetingroomBespeak bespeak);

}
