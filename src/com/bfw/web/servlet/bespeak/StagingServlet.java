package com.bfw.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bfw.domain.MeetingroomBespeak;
import com.bfw.domain.UserInfo;
import com.bfw.service.BespeakService;
import com.bfw.service.impl.BespeakServiceImpl;

/**
 * Servlet implementation class StagingServlet
 */
@WebServlet("/stagingServlet")
public class StagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StagingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取当前登录用户信息
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("userinfo");

		BespeakService bespeakService = new BespeakServiceImpl();

		// 查询预约会议室（未审核）
		MeetingroomBespeak meetbe = new MeetingroomBespeak();
		meetbe.setUserId(user.getUserId());
		meetbe.setBespeakState("0");
		List<MeetingroomBespeak> mylist = bespeakService
				.getAllMeetingroomBespeak(meetbe);
		request.setAttribute("mylist", mylist);

		// 查询预约会议室（审核通过）
		MeetingroomBespeak meetbe1 = new MeetingroomBespeak();
		meetbe1.setUserId(user.getUserId());
		meetbe1.setBespeakState("1");
		List<MeetingroomBespeak> myyeslist = bespeakService
				.getAllMeetingroomBespeak(meetbe1);
		request.setAttribute("myyeslist", myyeslist);

		// 查询预约会议室（审核未通过）
		MeetingroomBespeak meetbe2 = new MeetingroomBespeak();
		meetbe2.setUserId(user.getUserId());
		meetbe2.setBespeakState("2");
		List<MeetingroomBespeak> mynolist = bespeakService
				.getAllMeetingroomBespeak(meetbe2);
		request.setAttribute("mynolist", mynolist);

		// 查询预约会议室（查询未审核）
		MeetingroomBespeak meetbe3 = new MeetingroomBespeak();
		// meetbe2.setUserId(user.getUserId());
		meetbe3.setBespeakState("0");
		List<MeetingroomBespeak> noaanditlist = bespeakService
				.getAllMeetingroomBespeak(meetbe3);
		request.setAttribute("noaanditlist", noaanditlist);

		// 查询预约会议室（查询已经审核）
		MeetingroomBespeak meetbe4 = new MeetingroomBespeak();
		meetbe4.setUseUserId(user.getUserId());
		meetbe4.setMark("-1");
		List<MeetingroomBespeak> yesaanditlist = bespeakService
				.getAllMeetingroomBespeak(meetbe4);
		request.setAttribute("yesaanditlist", yesaanditlist);

		request.getRequestDispatcher("/staging.jsp").forward(request, response);

	}

}
