package com.bfw.web.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bfw.domain.UserInfo;
import com.bfw.service.UserInfoService;
import com.bfw.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//删除当前用户登录信息
		session.removeAttribute("userinfo");
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//业务逻辑层
		UserInfoService service = new UserInfoServiceImpl();

		
		//获取账号密码
		String userId = request.getParameter("userId");
		String passWord = request.getParameter("passWord");
		
		UserInfo user = service.isLogin(userId, passWord);
	//	System.out.println("账号"+userId+"密码:"+passWord);
		if(user!=null){
			//获取session
			HttpSession session = request.getSession();
			
			session.setAttribute("userinfo", user);
			//转发
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			
			request.setAttribute("info", "账号或密码错误！请重新输入");
			//转发
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

}
