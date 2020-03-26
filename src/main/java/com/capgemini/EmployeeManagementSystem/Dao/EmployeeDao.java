package com.capgemini.EmployeeManagementSystem.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.EmployeeManagementSystem.Model.Employee;

@Repository
public class EmployeeDao implements EmployeeDaoI{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(employee);
		return employee;
		
	}


	@Override
	public boolean deleteEmployee(int employeeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee p = (Employee) session.load(Employee.class,new Integer(employeeId));
		//System.out.println(p.getEmployeeName());
		if (null != p) {
			session.delete(p);
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		return employeeList;
		
	}


	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp=(Employee)session.load(Employee.class, new Integer(employeeId));
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setEmployeeSalary(employee.getEmployeeSalary());
		emp.setEmployeeAddress(employee.getEmployeeAddress());
		
		return emp;
	}


	

	

}
