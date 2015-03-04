package com.bfw.web.servlet.bespeak;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bfw.domain.MeetingRoom;
import com.bfw.domain.MeetingroomBespeak;
import com.bfw.domain.UserInfo;
import com.bfw.service.BespeakService;
import com.bfw.service.MeetingRoomService;
import com.bfw.service.UserInfoService;
import com.bfw.service.impl.BespeakServiceImpl;
import com.bfw.service.impl.MeetingRoomServiceImpl;
import com.bfw.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingRoomBespeakServlet
 */
@WebServlet("/meetingRoomBespeakServlet")
public class MeetingRoomBespeakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingRoomBespeakServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 会议室信息
		MeetingRoomService meetservice = new MeetingRoomServiceImpl();
		List<MeetingRoom> meetingroomlist = meetservice
				.getAllMeetingRoooms(null);
		request.setAttribute("meetingroomlist", meetingroomlist);

		// 参加会议人员
		UserInfoService userService = new UserInfoServiceImpl();
		List<UserInfo> userlist = userService.getAllUser(null);
		request.setAttribute("userlist", userlist);

		request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 会议室预约信息
		MeetingroomBespeak meeingBespeak = RequestBeanUtils
				.requestToSimpleBean(request, MeetingroomBespeak.class);

		// 参加会议人员信息
		String userIds = request.getParameter("userIds");

		/*System.out.println("参加会议人员:" + userIds);*/

		// 时间yyyy-MM-dd HH:mm:ss
		String stratTimeStr = request.getParameter("stratTimeStr");
		String endTimeStr = request.getParameter("endTimeStr");

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			if (meeingBespeak != null) {

				meeingBespeak.setStratTime(sdf.parse(stratTimeStr));
				meeingBespeak.setEndTime(sdf.parse(endTimeStr));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 当前登录用户信息(申请人)
		HttpSession session = request.getSession();
		UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
		meeingBespeak.setUserId(userinfo.getUserId());
		
		BespeakService serivce = new BespeakServiceImpl();
		boolean mark = serivce.addMeetingroomBespeak(meeingBespeak, userIds);
		
		if(mark){
			request.setAttribute("info", "预约会议室成功");
		}else{
			request.setAttribute("info", "预约会议室失败");
		}
		
		//request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak.jsp").forward(request, response);
		doGet(request, response);
	}

}
