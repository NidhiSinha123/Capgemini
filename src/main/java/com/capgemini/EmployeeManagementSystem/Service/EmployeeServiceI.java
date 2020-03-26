package com.capgemini.EmployeeManagementSystem.Service;

import java.util.List;

import com.capgemini.EmployeeManagementSystem.Model.Employee;

public interface EmployeeServiceI {
	public Employee addEmployee(Employee employee);
	public boolean deleteEmployee(int employeeId);
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(int id,Employee employee);
	

}
