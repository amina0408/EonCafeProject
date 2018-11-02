package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MenuDaoImpl;
import com.dao.MenuExistsException;
import com.model.Menu;
import com.service.MenuService;

/**
 * Servlet implementation class AddMenu
 */
@WebServlet("/AddMenu")
public class AddMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer=response.getWriter();

		response.setContentType("text/html");
		writer.append(" <html> <head> <title> Data Servlet </title> </head>");
		writer.append("<body>");
		
		
		
		//String mid  = request.getParameter("menuid");
		//int mid1=Integer.parseInt(mid);
		
		
		HttpSession session=request.getSession();
	      String nvid=(String)session.getAttribute("vid");		//get the vendor id from session
	      int nvid1=Integer.parseInt(nvid);		//convert the vendor id from string to integer
	      
	      
	      
		String mname1 = request.getParameter("menuname");	//accept the menu name 
		String mprice  =request.getParameter("price");	//accept the menu price
		int mprice1=Integer.parseInt(mprice);			//convert the menu price into int
		String vname  = request.getParameter("vendorname");		//accept the vendor name
		
		
		PrintWriter out = response.getWriter();
		
		//MenuDaoImpl menuDao=new MenuDaoImpl();
		MenuService menuservice=new MenuService();		//create an object of Menuservice
		
		Menu menu1=new Menu(nvid1,mname1,mprice1,vname);	//create a new object of menu by using the above parameters
		try {
			
			menuservice.addMenu(menu1);		//call the add menu function from menuservice layer
		} catch (MenuExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//ViewVendorOperation.jsp
		writer.append("<a href=\"ViewVendorOperation.jsp\"> Main Page  </a>");
		//writer.append("<input type=\"submit\" value=\"logout\"/>");
		writer.append("</form> </body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
