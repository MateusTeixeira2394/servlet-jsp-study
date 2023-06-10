package br.com.managerapp.services;

import java.util.ArrayList;

import br.com.managerapp.daos.CompanyDao;
import br.com.managerapp.models.Company;

public class CompanyService {
	
	private CompanyDao companyDao;
	
	public CompanyService() {
		companyDao = CompanyDao.getInstance();
	};
	
	public ArrayList<Company> getAll() {
		
		return companyDao.getAll();
		
	};
	
	public Company create(String name) {
		return companyDao.create(name);
	};
	
	public Company getById(int id) {
		return companyDao.getById(id);
	}
	
	public boolean edit(Company company) {
		return companyDao.edit(company);
	}
	
	public boolean delete(int id) {
		return companyDao.delete(id);
	}
	
}
