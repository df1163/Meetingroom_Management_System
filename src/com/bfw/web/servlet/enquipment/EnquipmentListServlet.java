package com.bfw.web.servlet.enquipment;

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
 * Servlet implementation class EnquipmentListServlet
 */
@WebServlet("/enquipmentListServlet")
public class EnquipmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentListServlet() {
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
		
		EnzhequipmentInfo eninfo = RequestBeanUtils.requestToSimpleBean(request, EnzhequipmentInfo.class);
		
		//设备信息管理业务逻辑处理的
		EnquipmentService service = new EnquipmentServiceImpl();
		
		List<EnzhequipmentInfo> list = service.selectEnquipmentInfo(eninfo);
		
		request.setAttribute("list", list);
		
		
		
		//会议室管理的业务逻辑处理类
		MeetingRoomService meetservice = new MeetingRoomServiceImpl();
		List<MeetingRoom> meetroomlist = meetservice.getAllMeetingRoooms(null);
		request.setAttribute("meetroomlist", meetroomlist);
		
		
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_list.jsp").forward(request, response);
		
		
	}

}
