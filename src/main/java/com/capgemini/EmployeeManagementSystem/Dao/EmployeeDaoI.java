package com.capgemini.EmployeeManagementSystem.Dao;

import java.util.List;

import com.capgemini.EmployeeManagementSystem.Model.Employee;

public interface EmployeeDaoI {

	public Employee addEmployee(Employee employee);
	public boolean deleteEmployee(int employeeId);
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(int id,Employee employee);
	
}
