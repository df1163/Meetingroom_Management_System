package com.bfw.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.MeetingroomBespeak;
import com.bfw.service.BespeakService;
import com.bfw.service.impl.BespeakServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingRoomBespeakAuditingServlet
 */
@WebServlet("/meetingRoomBespeakAuditingServlet")
public class MeetingRoomBespeakAuditingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomBespeakAuditingServlet() {
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
		//获取页面数据
		MeetingroomBespeak meetingroomBeapeak = RequestBeanUtils.requestToSimpleBean(request, MeetingroomBespeak.class);
		
		
		BespeakService service = new BespeakServiceImpl();
		
		if(meetingroomBeapeak == null){
			meetingroomBeapeak = new MeetingroomBespeak();
		}
		
		meetingroomBeapeak.setBespeakState("0");
		
		List<MeetingroomBespeak> list = service.getAllMeetingroomBespeak(meetingroomBeapeak);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak_auditing.jsp").forward(request, response);
		
	}

}
