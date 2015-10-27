package com.Customs.CIA.service;

import java.util.List;

import com.Customs.CIA.model.Employee;

public interface EmployeeService {
	List<Employee> listEmployee();
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int EmployeeID);
	public Employee getEmployeeById(int EmployeeID);
}
