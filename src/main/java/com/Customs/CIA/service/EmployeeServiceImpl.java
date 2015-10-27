package com.Customs.CIA.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Customs.CIA.dao.EmployeeDAO;
import com.Customs.CIA.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return this.employeeDAO.listEmployee();
	}
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeDAO.updateEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int EmployeeID) {
		// TODO Auto-generated method stub
		this.employeeDAO.deleteEmployee(EmployeeID);
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int EmployeeID) {
		// TODO Auto-generated method stub
		return this.employeeDAO.getEmployeeById(EmployeeID);
	}

}
