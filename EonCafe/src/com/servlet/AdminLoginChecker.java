package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginChecker
 */
@WebServlet("/AdminLoginChecker")
public class AdminLoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminId="admin";
		String adminPwd="admin";
		
		
		String admin_id=request.getParameter("User id");
		String admin_pwd=request.getParameter("password");
		
		if(admin_id.equals(adminId)&&admin_pwd.equals(adminPwd))
		{
			System.out.println("hello");
			HttpSession session = request.getSession(true);	
			request.setAttribute("Id", adminId);
			session.setAttribute("AdminId",adminId );
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ViewAdminOperation.jsp");
			requestDispatcher.forward(request, response);
			
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
