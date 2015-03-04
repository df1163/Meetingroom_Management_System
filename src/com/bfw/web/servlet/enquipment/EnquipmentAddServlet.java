package com.bfw.web.servlet.enquipment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bfw.domain.EnzhequipmentInfo;
import com.bfw.domain.UserInfo;
import com.bfw.service.EnquipmentService;
import com.bfw.service.impl.EnquipmentServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class EnquipmentAddServlet
 */
@WebServlet("/enquipmentAddServlet")
public class EnquipmentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnquipmentAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取页面数据
		EnzhequipmentInfo eninfo = RequestBeanUtils.requestToSimpleBean(
				request, EnzhequipmentInfo.class);

		// 业务逻辑处理
		EnquipmentService service = new EnquipmentServiceImpl();

		// 从session中获取当前登录用户信息
		HttpSession session = request.getSession();
		UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");

		// 获取采购时间
		String procurementDateTime = request
				.getParameter("procurementDateTime");

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(procurementDateTime);
			if (eninfo != null) {
				eninfo.setProcurementTime(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (eninfo != null && userinfo != null) {
			eninfo.setUserId(userinfo.getUserId());
		}

		boolean mark = service.addEnquipment(eninfo);

		if (mark) {
			request.setAttribute("info", "添加设备信息成功");
		} else {
			request.setAttribute("info", "添加设备信息失败");
		}

		// 转发
		request.getRequestDispatcher(
				"/view/enzhequipment/enzhequipment_add.jsp").forward(request,
				response);
	}

}
