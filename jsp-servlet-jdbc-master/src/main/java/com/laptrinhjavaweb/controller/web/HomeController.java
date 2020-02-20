package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;

@WebServlet(urlPatterns = { "/trang-chu" })
public class HomeController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newsService;
	private static final long serialVersionUID = 2686801510274002166L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.print(categoryService.findAll());
		request.setAttribute("categories", categoryService.findAll());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
		//rd.forward(request, response);
		
		
		//
		RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
		rd.forward(request, response);
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
