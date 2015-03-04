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
 * Servlet implementation class EnquipmentUpdateServlet
 */
@WebServlet("/enquipmentUpdateServlet")
public class EnquipmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enzhequipmentId = request.getParameter("enzhequipmentId");
		
		//业务
		EnquipmentService service = new EnquipmentServiceImpl();
		
		EnzhequipmentInfo eninfo = service.getEnzhequipmentInfo(enzhequipmentId);
		
		request.setAttribute("eninfo", eninfo);
		
		//转发
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_update.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取页面数据
		EnzhequipmentInfo eninfo = RequestBeanUtils.requestToSimpleBean(
				request, EnzhequipmentInfo.class);

		// 业务逻辑处理
		EnquipmentService service = new EnquipmentServiceImpl();

		boolean mark = service.updateEnzhequipmentInfo(eninfo);

		//查询设备信息
		EnzhequipmentInfo eninfoss = service.getEnzhequipmentInfo(eninfo.getEnzhequipmentId()+"");
		request.setAttribute("eninfo", eninfoss);
		if (mark) {
			request.setAttribute("info", "修改设备信息成功");
		} else {
			request.setAttribute("info", "修改设备信息失败");
		}

		// 转发
		request.getRequestDispatcher(
				"/view/enzhequipment/enzhequipment_update.jsp").forward(request,
				response);
	}

}
