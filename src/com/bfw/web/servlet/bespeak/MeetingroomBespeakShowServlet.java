package com.bfw.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.MeetingUserinfo;
import com.bfw.domain.MeetingroomBespeak;
import com.bfw.service.BespeakService;
import com.bfw.service.MeetingUserinfoService;
import com.bfw.service.impl.BespeakServiceImpl;
import com.bfw.service.impl.MeetingUserinfoServiceImpl;

/**
 * Servlet implementation class MymeetingroomBespeakShowServlet
 */
@WebServlet("/meetingroomBespeakShowServlet")
public class MeetingroomBespeakShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomBespeakShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取预约会议室编号
		String bespeakId = request.getParameter("bespeakId");
		System.out.println("编号" + bespeakId);
		
		// 预约会议室信息
		BespeakService service = new BespeakServiceImpl();
		MeetingroomBespeak bespeak = service.getMeetingroomBespeak(Integer
				.parseInt(bespeakId));
		request.setAttribute("bespeak", bespeak);
		
		
		// 具体参加会议人员
		MeetingUserinfoService muservice = new MeetingUserinfoServiceImpl();
		MeetingUserinfo mu = new MeetingUserinfo();
		mu.setBespeakId(Integer.parseInt(bespeakId));
		List<MeetingUserinfo> mulist = muservice.getAllMeetingUserinfo(mu);
		request.setAttribute("mulist", mulist);
		
		request.getRequestDispatcher(
				"/view/bespeak/meetingroom_bespeak_show.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
