package br.com.managerapp.daos;

import java.util.ArrayList;

import br.com.managerapp.models.Company;

public class CompanyDao {

	private static CompanyDao instance;
	private ArrayList<Company> companies;
	private int lastId = 0;

	private CompanyDao() {
		companies = new ArrayList<Company>();
	}

	public static CompanyDao getInstance() {

		if (instance == null) {
			instance = new CompanyDao();
		}

		return instance;
	}

	public ArrayList<Company> getAll() {
		return companies;
	}

	public Company create(String name) {

		Company newCompany = new Company(++lastId, name);

		companies.add(newCompany);

		return newCompany;

	}

	public Company getById(int id) {
		
		int index = this.findIndexById(id);
		
		if(index == -1) return null;
		
		return companies.get(index);
		
	}

	public boolean edit(Company company) {
		
		int index = this.findIndexById(company.getId());
		
		if(index == -1) return false;
		
		Company storageCompany = companies.get(index);
		
		storageCompany.setName(company.getName());
		
		return true;
		
	}
	
	public boolean delete(int id) {
		
		int index = this.findIndexById(id);
		
		if(index == -1) return false;
		
		companies.remove(index);
		
		return true;
		
	}

	private int findIndexById(int id) {

		for (int i = 0; i < companies.size(); i++) {

			if (companies.get(i).getId() == id) {
				return i;
			}

		}

		return -1;

	}

}
