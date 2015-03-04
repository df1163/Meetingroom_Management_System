package com.bfw.web.servlet.meetingroom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.EnzhequipmentInfo;
import com.bfw.domain.MeetingRoom;
import com.bfw.service.EnquipmentService;
import com.bfw.service.MeetingRoomService;
import com.bfw.service.impl.EnquipmentServiceImpl;
import com.bfw.service.impl.MeetingRoomServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingRoomUpdateServlet
 */
@WebServlet("/meetingRoomUpdateServlet")
public class MeetingRoomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingRoomUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 会议室编号
		String meetingroomId = request.getParameter("meetingroomId");

		// 业务逻辑处理
		MeetingRoomService service = new MeetingRoomServiceImpl();

		MeetingRoom meetingroom = service.getMeetingRoom(meetingroomId);

		request.setAttribute("meetingroom", meetingroom);

		// 设备信息的业务处理实现类
		EnquipmentService enservice = new EnquipmentServiceImpl();
		EnzhequipmentInfo info = new EnzhequipmentInfo();
		info.setMeetingroomId(Integer.parseInt(meetingroomId));
		List<EnzhequipmentInfo> enlist = enservice.selectEnquipmentInfo(info);

		List<EnzhequipmentInfo> list = enservice.queryEnzhequipmentInfo();

		request.setAttribute("eninfolist", list);

		request.setAttribute("enlist", enlist);

		request.getRequestDispatcher("/view/meetingroom/meetingroom_update.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获得会议室信息
		MeetingRoom meetingroom = RequestBeanUtils.requestToSimpleBean(request,
				MeetingRoom.class);
		
		//设备编号信息
		String enzhequipmentIds = request.getParameter("enzhequipmentIds");
				
		MeetingRoomService service = new MeetingRoomServiceImpl();
		boolean mark = service.updatemeetingRoom(meetingroom, enzhequipmentIds);
		
		if(mark){
			request.setAttribute("info", "会议室信息修改成功");
		}else{
			request.setAttribute("info", "会议室信息修改失败");
		}
		
		doGet(request, response);
		
	}

}
