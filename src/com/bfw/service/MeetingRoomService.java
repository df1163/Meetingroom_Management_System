package com.bfw.service;

import java.util.List;

import com.bfw.domain.MeetingRoom;

/**
 * ��������Ϣ������ҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface MeetingRoomService {
	
	/**
	 * ��ѯ��������Ϣ
	 * @param meetingroom ��ѯ����
	 * @return ���ض����������Ϣ
	 */
	public List<MeetingRoom> getAllMeetingRoooms(MeetingRoom meetingroom);
	
	/**
	 * ���ӻ�������Ϣ
	 * @param meetingroom ��������Ϣ
	 * @param enzhequipmentIds �������豸��Ϣ
	 * @return true �ɹ� falseʧ��
	 */
	public boolean addMeetingRoom(MeetingRoom meetingroom,String enzhequipmentIds);
	
	/**
	 * ���ݱ�Ų�ѯ��������Ϣ
	 * @param meetingroomId �����ұ��
	 * @return
	 */
	public MeetingRoom getMeetingRoom(String meetingroomId);
	
	/**
	 * �޸Ļ�������Ϣ
	 * @param meetingroom ��������Ϣ
	 * @param enzhequipmentIds �豸���
	 * @return true�ɹ� false ʧ��
	 */
	public boolean updatemeetingRoom(MeetingRoom meetingroom,String enzhequipmentIds);
	
	/**
	 * ���߱��ɾ����������Ϣ
	 * @param meetingroomId �����ұ��
	 * @return
	 */
	public boolean deleteMeetingRoom(String meetingroomId);

}