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
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MymeetingroomBespeakAudqueryServlet
 */
@WebServlet("/mymeetingroomBespeakAudqueryServlet")
public class MymeetingroomBespeakAudqueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MymeetingroomBespeakAudqueryServlet() {
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
		MeetingroomBespeak bespeak = RequestBeanUtils.requestToSimpleBean(
				request, MeetingroomBespeak.class);

		// 业务
		BespeakService bespeakService = new BespeakServiceImpl();

		// 查询未审核的预约信息
		if (bespeak == null) {
			bespeak = new MeetingroomBespeak();
		}

		HttpSession session = request.getSession();

		UserInfo user = (UserInfo) session.getAttribute("userinfo");
		
		//根据审核人查询信息
		bespeak.setUseUserId(user.getUserId());

		List<MeetingroomBespeak> list = bespeakService
				.getAllMeetingroomBespeak(bespeak);
		
		for(MeetingroomBespeak mb:list){
			if("0".equals(mb.getBespeakState())){
				mb.setBespeakState("未审核");
			}
			if("1".equals(mb.getBespeakState())){
				mb.setBespeakState("通过");
			}
			if("2".equals(mb.getBespeakState())){
				mb.setBespeakState("不通过");
			}
		}

		request.setAttribute("list", list);

		request.getRequestDispatcher(
				"/view/bespeak/mymeetingroom_bespeak_audquery.jsp").forward(
				request, response);
	}

}
