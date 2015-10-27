package com.Customs.CIA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.Customs.CIA.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
		
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		String hql = "FROM Employee";
		Query query = getCurrentSession().createQuery(hql);
		List<Employee> empList = query.list();
		for(Employee employee : empList){
			logger.info("Person List::" +employee);
		}
		return empList;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		getCurrentSession().persist(employee);
		logger.info("Employee saved successfully, Employee Details="+employee);
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		getCurrentSession().update(employee);
		logger.info("Employee updated successfully, Employee Details="+employee);
	}

	@Override
	public void deleteEmployee(int EmployeeID) {
		// TODO Auto-generated method stub
		Employee employee = (Employee) getCurrentSession().load(Employee.class, new Integer(EmployeeID));
		if(employee != null){
			getCurrentSession().delete(employee);
		}
		logger.info("Employee deleted successfully, employee details="+employee);
	}

	@Override
	public Employee getEmployeeById(int EmployeeID) {
		// TODO Auto-generated method stub
		Employee employee = (Employee) getCurrentSession().load(Employee.class, new Integer(EmployeeID));
		logger.info("Employee loaded successfully, employee details="+employee);
		return employee;		
	}

}
