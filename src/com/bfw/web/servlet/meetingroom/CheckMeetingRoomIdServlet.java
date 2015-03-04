package com.bfw.web.servlet.meetingroom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.MeetingRoom;
import com.bfw.service.MeetingRoomService;
import com.bfw.service.impl.MeetingRoomServiceImpl;

/**
 * Servlet implementation class CheckMeetingRoomIdServlet
 */
@WebServlet("/checkMeetingRoomIdServlet")
public class CheckMeetingRoomIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMeetingRoomIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//会议室编号
		String meetingroomId = request.getParameter("meetingroomId");
		
		//业务逻辑处理
		MeetingRoomService service = new MeetingRoomServiceImpl();
		
		MeetingRoom meetingroom = service.getMeetingRoom(meetingroomId);
		
		//相应
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		if(meetingroom!=null){
			out.println("<font size='2' style='color: red;'>编号已经存在，请重新输入编号</font>");
		}else{
			out.println("<font size='2' style='color: green;'>恭喜您，编号可以使用</font>");
		}
		
		out.flush();
		out.close();

	}

}
