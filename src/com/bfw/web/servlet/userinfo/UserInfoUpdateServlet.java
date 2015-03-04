package com.bfw.web.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bfw.domain.UserInfo;
import com.bfw.service.UserInfoService;
import com.bfw.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/userInfoUpdateServlet")
@MultipartConfig
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoUpdateServlet() {
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

		System.out.println(userId);

		// 业务逻辑处理
		UserInfoService service = new UserInfoServiceImpl();
		UserInfo user = service.getUser(userId);

		request.setAttribute("user", user);

		request.getRequestDispatcher("/view/userinfo/userinfo_update.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 把request中数据此存放UserInfo对象里面
		UserInfo userinfo = RequestBeanUtils.requestToSimpleBean(request,
				UserInfo.class);

		// 业务逻辑处理
		UserInfoService service = new UserInfoServiceImpl();
		
		Part part = request.getPart("userUrl");
	

		String root = request.getServletContext().getRealPath("//upload");

		String name = part.getHeader("content-disposition");

		if (name.lastIndexOf(".") != -1) {
			String ext = name.substring(name.lastIndexOf("."),
					name.length() - 1);

			String url = root + "//" + userinfo.getUserId() + ext;
			userinfo.setUserUrl("upload//" + userinfo.getUserId() + ext);

			part.write(url);
		}
		boolean mark = service.updateUser(userinfo);
		
		if(mark){
			UserInfo user = service.getUser(userinfo.getUserId());

			request.setAttribute("user", user);
			request.setAttribute("info", "修改用户信息成功");
		}else{
			request.setAttribute("info", "修改用户信息失败");
		}
		
		request.getRequestDispatcher("/view/userinfo/userinfo_update.jsp")
		.forward(request, response);

	}

}
