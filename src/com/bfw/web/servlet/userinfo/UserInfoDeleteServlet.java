package com.bfw.web.servlet.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.UserInfo;
import com.bfw.service.UserInfoService;
import com.bfw.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfoDeleteServlet
 */
@WebServlet("/userInfoDeleteServlet")
public class UserInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");

		// 业务逻辑接口
		UserInfoService service = new UserInfoServiceImpl();

		boolean mark = service.deleteUser(userId);
		List<UserInfo> list= service.getAllUser(null);
		request.setAttribute("list", list);
		if(mark){
		
			request.setAttribute("info", "删除用户信息成功");
		}else{
			request.setAttribute("info", "删除用户信息失败");
		}
		
		
		//转发
		request.getRequestDispatcher("/view/userinfo/userinfo_list.jsp").forward(request, response);
				
	}

}
