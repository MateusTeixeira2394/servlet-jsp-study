package br.com.managerapp.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.managerapp.constants.CompanyConstants;
import br.com.managerapp.models.Company;
import br.com.managerapp.services.CompanyService;

/**
 * Servlet implementation class CompaniesController
 */
@WebServlet(CompanyConstants.COMPANIES_ROUTE)
public class CompaniesController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CompanyService companyService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompaniesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		companyService = new CompanyService();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Company> companies = companyService.getAll();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Companies.jsp");
		
		request.setAttribute("companies", companies);

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
