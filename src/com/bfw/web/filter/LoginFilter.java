package com.bfw.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bfw.domain.UserInfo;

/**
 * 
 * @author 
 *
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {

		// °ÑServletRequest to HttpServletRequest
		HttpServletRequest httprequest = (HttpServletRequest) request;

		// get session
		HttpSession seesion = httprequest.getSession();
		UserInfo user = (UserInfo) seesion.getAttribute("userinfo");

		//get url
		String url = httprequest.getRequestURI();
		if (url.contains("/assets/")) {
			fc.doFilter(request, response);
		} else if (url.contains("/css/")) {
			fc.doFilter(request, response);
		} else if (url.contains("/font/")) {
			fc.doFilter(request, response);
		}else if (url.contains("/login.jsp")) {
			fc.doFilter(request, response);
		} else if (url.contains("/images/")) {
			fc.doFilter(request, response);
		} else if (url.contains("/js/")) {
			fc.doFilter(request, response);
		} else if (url.contains("/loginServlet")) {
			fc.doFilter(request, response);
		} else if (user != null) { // if user exists in session
			fc.doFilter(request, response);
		} else {
			httprequest.getRequestDispatcher("/login_info.jsp").forward(httprequest,
					response);

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
