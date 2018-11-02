package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CartDaoImpl;
import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer=response.getWriter();
		writer.append("<html><head><title>Data Servlet</title></head>");
		writer.append("<body>");
		
		String cid1=request.getParameter("cid");
		int cid2 = Integer.parseInt(cid1);
		String cname=request.getParameter("cname");
		String cemail=request.getParameter("cemail");
		String cpassword=request.getParameter("cpassword");
		
		//System.out.println("details of new course:"+cid2+cname+cduration+cfees);
		
		Customer customer=new Customer(cid2, cname, cemail, cpassword);
		CustomerDao customerDaoimpl = new CustomerDaoImpl();
		try {
			customerDaoimpl.addCustomer(customer);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writer.println(e);
		}
		
		writer.append("Customer Added Successfully");
		writer.append("<br>");
		
		List<Customer> allCustomers = customerDaoimpl.getAllCustomers();
		
		for(Customer c:allCustomers)
		{
			writer.append("<br>");
			writer.append(c.getCid()+" "+c.getCname()+" "+c.getCemail()+" "+c.getCpassword());
			
		}
		
		writer.append("</body></html>");
		
	}

}
