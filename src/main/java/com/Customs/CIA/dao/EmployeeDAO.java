package com.Customs.CIA.dao;

import java.util.List;

import com.Customs.CIA.model.Employee;

public interface EmployeeDAO {
	public List<Employee> listEmployee();
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int EmployeeID);
	public Employee getEmployeeById(int EmployeeID);
}
