package com.bfw.web.servlet.enquipment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.EnzhequipmentInfo;
import com.bfw.service.EnquipmentService;
import com.bfw.service.impl.EnquipmentServiceImpl;

/**
 * Servlet implementation class EnquipmentDeleteServlet
 */
@WebServlet("/enquipmentDeleteServlet")
public class EnquipmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnquipmentDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String enzhequipmentId = request.getParameter("enzhequipmentId");

		EnquipmentService service = new EnquipmentServiceImpl();
		

		boolean mark = service.deleteEnzhequipmentInfo(enzhequipmentId);
		
		List<EnzhequipmentInfo> list = service.getAllEnzhequipmentInfo(null);
		request.setAttribute("list", list);
		if (mark) {
			request.setAttribute("info", "删除设备信息成功");

		} else {
			request.setAttribute("info", "删除设备信息失败");
		}

		request.getRequestDispatcher(
				"/view/enzhequipment/enzhequipment_main.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
