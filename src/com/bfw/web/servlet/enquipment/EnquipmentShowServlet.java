package com.bfw.web.servlet.enquipment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.EnzhequipmentInfo;
import com.bfw.service.EnquipmentService;
import com.bfw.service.impl.EnquipmentServiceImpl;

/**
 * Servlet implementation class EnquipmentShowServlet
 */
@WebServlet("/enquipmentShowServlet")
public class EnquipmentShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//…Ë±∏±‡∫≈
		String enzhequipmentId = request.getParameter("enzhequipmentId");
		
		EnquipmentService service = new EnquipmentServiceImpl();
		EnzhequipmentInfo eninfo = service.showEnzhequipmentInfo(enzhequipmentId);
		
		request.setAttribute("eninfo", eninfo);
		
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_show.jsp").forward(request, response);
			
	}

	/**re
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
