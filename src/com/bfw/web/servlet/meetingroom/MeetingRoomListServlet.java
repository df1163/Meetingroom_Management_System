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
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingRoomListServlet
 */
@WebServlet("/meetingRoomListServlet")
public class MeetingRoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从页面获取数据
		MeetingRoom meetingroom = RequestBeanUtils.requestToSimpleBean(request,
				MeetingRoom.class);
		
		MeetingRoomService service = new MeetingRoomServiceImpl();
		List<MeetingRoom> list = service.getAllMeetingRoooms(meetingroom);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_list.jsp").forward(request, response);
		
	}

}
