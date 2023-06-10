package br.com.managerapp.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.managerapp.constants.CompanyConstants;
import br.com.managerapp.models.Company;
import br.com.managerapp.services.CompanyService;

/**
 * Servlet implementation class NewCompanyController
 */
@WebServlet(CompanyConstants.NEW_COMPANY_ROUTE)
public class NewCompanyController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CompanyService companyService;

	/**
	 * Default constructor.
	 */
	public NewCompanyController() {
		// TODO Auto-generated constructor stub

	}

	public void init() throws ServletException {
		super.init();

		companyService = new CompanyService();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("NewCompanyForm.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String baseUrl = request.getContextPath();

		String companyName = request.getParameter("name");

		Company company = companyService.create(companyName);

		response.sendRedirect(baseUrl + CompanyConstants.SHOW_COMPANY_ROUTE + "?id=" + company.getId());

	}

}
