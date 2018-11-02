package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.DBConnection;

/**
 * Servlet implementation class CustomerLoginChecker
 */
@WebServlet("/CustomerLoginChecker")
public class CustomerLoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String cid=request.getParameter("userid").trim();		//accept the customer id
			String pwd=request.getParameter("password").trim();		//accept the password from customer
			System.out.println("reading the username and password "+ cid + " " + pwd);
			
			HttpSession session=request.getSession();
		    session.setAttribute("cid",cid);	//set the customer id for the entire session 
		    session.setAttribute("cpassword",pwd);	
			
		    PrintWriter writer=response.getWriter();
			Connection con = null;
			DBConnection dbm = new DBConnection();	//connect to the database inorder to validate the customer by checking
													//the customer id and password
			try
			{
			
				System.out.println("in try");
				
				PrintWriter out = response.getWriter();
				
				try
				{
					if(cid!=null)
					{
					 con = dbm.getConnection();
					String sql = "SELECT * FROM Customer WHERE cid=? AND cpassword=?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, cid);
					ps.setString(2, pwd);
					
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						
						
						response.sendRedirect("AllMenuServletCustomer");
						System.out.println("Redirect to Customer Login");
					}
					else
					{
						
						response.sendRedirect("ViewCustomerLogin.jsp");
						System.out.println("once again login");
						
					}
					
				}
				}
			
				catch(Exception e)
				{
					out.print("Sorry Unable to Communicate with Database...");
					e.printStackTrace();
				}
			}
				finally
				{
					
				}		
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
