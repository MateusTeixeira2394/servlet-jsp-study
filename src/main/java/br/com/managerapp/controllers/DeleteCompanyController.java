package br.com.managerapp.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.managerapp.constants.CompanyConstants;
import br.com.managerapp.daos.CompanyDao;
import br.com.managerapp.models.Company;
import br.com.managerapp.services.CompanyService;

/**
 * Servlet implementation class DeleteCompanyController
 */
@WebServlet("/delete-company")
public class DeleteCompanyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private CompanyService companyService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCompanyController() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher rd = request.getRequestDispatcher("DeleteCompany.jsp");
		
		Company company = companyService.getById(id);
		
		request.setAttribute("company", company);
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String baseUrl = request.getContextPath();		
		
		int id = Integer.parseInt(request.getParameter("id"));

		companyService.delete(id);

		response.sendRedirect(baseUrl + CompanyConstants.COMPANIES_ROUTE);
		
	}
	

}
