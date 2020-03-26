package com.capgemini.EmployeeManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.EmployeeManagementSystem.Model.Employee;
import com.capgemini.EmployeeManagementSystem.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		Employee emp = employeeService.addEmployee(employee);
		if(emp!=null)
		{
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("employee not added",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/showEmployees")
	public ResponseEntity<?> showEmployee()
	{
		List<Employee> listOfEmployee = employeeService.getAllEmployees();
		if(listOfEmployee!=null)
		{
			return new ResponseEntity<List>(listOfEmployee,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No employees found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestParam("empId") String empId,@ModelAttribute Employee employee)
	{
		Integer employeeId = Integer.parseInt(empId);
		Employee em = employeeService.updateEmployee(employeeId,employee);
		if(em!=null)
		{
			return new ResponseEntity<Employee>(em,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Employee not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<?> deleteEmployee(@RequestParam("empId") String empId)
	{
		Integer employeeId = Integer.parseInt(empId);
		boolean status = employeeService.deleteEmployee(employeeId);
		if(status)
		{
			return new ResponseEntity<String>("employee deleted successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("employee not deleted",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
