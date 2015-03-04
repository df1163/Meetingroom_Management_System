package com.bfw.web.servlet.bespeak;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.MeetingRoom;
import com.bfw.domain.MeetingUserinfo;
import com.bfw.domain.MeetingroomBespeak;
import com.bfw.domain.UserInfo;
import com.bfw.service.BespeakService;
import com.bfw.service.MeetingRoomService;
import com.bfw.service.MeetingUserinfoService;
import com.bfw.service.UserInfoService;
import com.bfw.service.impl.BespeakServiceImpl;
import com.bfw.service.impl.MeetingRoomServiceImpl;
import com.bfw.service.impl.MeetingUserinfoServiceImpl;
import com.bfw.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingroomBespeakUpdateServlet
 */
@WebServlet("/meetingroomBespeakUpdateServlet")
public class MeetingroomBespeakUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingroomBespeakUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取预约会议室编号
		String bespeakId = request.getParameter("bespeakId");
		System.out.println("编号" + bespeakId);

		// 预约会议室信息
		BespeakService service = new BespeakServiceImpl();
		MeetingroomBespeak bespeak = service.getMeetingroomBespeak(Integer
				.parseInt(bespeakId));
		request.setAttribute("bespeak", bespeak);

		// 会议室信息
		MeetingRoomService meetservice = new MeetingRoomServiceImpl();
		List<MeetingRoom> meetingroomlist = meetservice
				.getAllMeetingRoooms(null);
		request.setAttribute("meetingroomlist", meetingroomlist);

		// 查询出所有人员
		UserInfoService userService = new UserInfoServiceImpl();
		UserInfo user = new UserInfo();
		user.setBespeakId(Integer.parseInt(bespeakId));
		List<UserInfo> userlist = userService.getAllUser(user);
		request.setAttribute("userlist", userlist);

		// 具体参加会议人员
		MeetingUserinfoService muservice = new MeetingUserinfoServiceImpl();
		MeetingUserinfo mu = new MeetingUserinfo();
		mu.setBespeakId(Integer.parseInt(bespeakId));
		List<MeetingUserinfo> mulist = muservice.getAllMeetingUserinfo(mu);
		request.setAttribute("mulist", mulist);

		request.getRequestDispatcher(
				"/view/bespeak/meetingroom_bespeak_update.jsp").forward(
				request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//获取页面信息
		MeetingroomBespeak bespeak = RequestBeanUtils.requestToSimpleBean(
				request, MeetingroomBespeak.class);
		
		//会议参加人员账号
		String userIds = request.getParameter("userIds");
		
		//获取时间
		String stratTimestr = request.getParameter("stratTimestr");
		String endTimestr = request.getParameter("endTimestr");
		
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			bespeak.setStratTime(sdf.parse(stratTimestr));
			bespeak.setEndTime(sdf.parse(endTimestr));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//业务逻辑层
		BespeakService service =  new BespeakServiceImpl();
		
		boolean mark = service.updateMeetingroomBespeak(bespeak, userIds);

		if(mark){
			request.setAttribute("info", "预约会议室修改成功");
		}else{
			request.setAttribute("info", "预约会议室修改失败");
		}
		doGet(request, response);

	}

}
