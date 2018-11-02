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
import com.model.Menu;
import com.service.MenuService;

import javafx.scene.input.Mnemonic;

/**
 * Servlet implementation class UpdateMenu
 */
@WebServlet("/UpdateMenu")
public class UpdateMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMenu() {
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
		
		HttpSession session=request.getSession();
	      String nvid=(String)session.getAttribute("vid");
	      int nvid1=Integer.parseInt(nvid);
		
		String mid  = request.getParameter("menuid");
		int mid1=Integer.parseInt(mid);
		//String vid  = request.getParameter("vid");	
		//int vid1=Integer.parseInt(vid);
		//String mname1 = request.getParameter("mname");
		String mprice  =request.getParameter("price");
		int mprice1=Integer.parseInt(mprice);
		//String vname  = request.getParameter("vname");
		
		
		PrintWriter out = response.getWriter();
		//MenuDaoImpl menuDao=new MenuDaoImpl();
		//menuDao.updateMenu(mprice1,mid1,nvid1);
		MenuService menuservice=new MenuService();
		menuservice.updateMenu(mprice1, mid1, nvid1);
		out.println("Menu data updated ");
		//Menu menu1=new Menu(mid1,vid1,mname1,mprice1,vname);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
