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

/**
 * Servlet implementation class MeetingRoomShowServlet
 */
@WebServlet("/meetingRoomShowServlet")
public class MeetingRoomShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingRoomShowServlet() {
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

		MeetingRoomService service = new MeetingRoomServiceImpl();
		MeetingRoom meetingroom = service.getMeetingRoom(meetingroomId);
		request.setAttribute("meetingroom", meetingroom);
		
		//查询会议室所属设备信息
		EnquipmentService enservice = new EnquipmentServiceImpl();
		
		EnzhequipmentInfo info = new EnzhequipmentInfo();
		info.setMeetingroomId(Integer.parseInt(meetingroomId));
		
		List<EnzhequipmentInfo> enlist = enservice.selectEnquipmentInfo(info);
		request.setAttribute("enlist", enlist);
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
