package com.bfw.web.servlet.meetingroom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.MeetingRoom;
import com.bfw.service.MeetingRoomService;
import com.bfw.service.impl.MeetingRoomServiceImpl;

/**
 * Servlet implementation class MeetingRoomDeleteServlet
 */
@WebServlet("/meetingRoomDeleteServlet")
public class MeetingRoomDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingRoomDeleteServlet() {
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

		boolean mark = service.deleteMeetingRoom(meetingroomId);
		if (mark) {
			request.setAttribute("info", "删除会议室信息成功");
		} else {
			request.setAttribute("info", "删除会议室信息失败");
		}

		List<MeetingRoom> list = service.getAllMeetingRoooms(null);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/meetingroom/meetingroom_main.jsp").forward(request, response);
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
