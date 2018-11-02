package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MenuDaoImpl;
import com.dao.VendorDaoImpl;
import com.model.Menu;
import com.service.MenuService;

/**
 * Servlet implementation class AllMenuServlet
 */
@WebServlet("/AllMenuServlet")
public class AllMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.append("<html><head><title>Data Servlet</title></head>");
		writer.append("<body>");
		
		MenuService menuService=new MenuService();
		List<Menu> allMenu = menuService.getAllMenu();
		request.setAttribute("menuList", allMenu);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAllMenu.jsp");
		requestDispatcher.forward(request, response);
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
