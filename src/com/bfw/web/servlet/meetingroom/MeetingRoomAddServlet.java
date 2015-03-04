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
 * Servlet implementation class MeetingRoomAddServlet
 */
@WebServlet("/meetingRoomAddServlet")
public class MeetingRoomAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设备信息的业务处理实现类
		EnquipmentService service = new EnquipmentServiceImpl();
		
		List<EnzhequipmentInfo> list = service.queryEnzhequipmentInfo();
		
		request.setAttribute("eninfolist", list);
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//从页面获取信息
		MeetingRoom meetingroom = RequestBeanUtils.requestToSimpleBean(request,
				MeetingRoom.class);
		
		//设备编号 会议室所属设备
		String enzhequipmentIds = request.getParameter("enzhequipmentIds");
		
		
		System.out.println(meetingroom);
		System.out.println(enzhequipmentIds);
		
		//会议室管理的业务逻辑处理
		MeetingRoomService service = new MeetingRoomServiceImpl();
		
		boolean mark = service.addMeetingRoom(meetingroom, enzhequipmentIds);
		
		if(mark){
			request.setAttribute("info", "添加会议室信息成功");
		}else{
			request.setAttribute("info", "添加会议室信息失败");
		}
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_add.jsp").forward(request, response);
	}

}
