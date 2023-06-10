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
 * Servlet implementation class EditCompanyController
 */
@WebServlet("/edit-company")
public class EditCompanyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	CompanyService companyService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCompanyController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	companyService = new CompanyService();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Company company = companyService.getById(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("EditCompanyForm.jsp");
		
		request.setAttribute("company", company);
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String baseUrl = request.getContextPath();

		String companyName = request.getParameter("name");
		
		int id = Integer.parseInt(request.getParameter("id"));

		companyService.edit(new Company(id, companyName));

		response.sendRedirect(baseUrl + CompanyConstants.SHOW_COMPANY_ROUTE + "?id=" + id);
		
	}

}
