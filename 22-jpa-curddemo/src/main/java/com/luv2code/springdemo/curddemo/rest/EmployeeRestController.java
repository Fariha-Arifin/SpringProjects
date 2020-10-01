package com.luv2code.springdemo.curddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.curddemo.dao.EmployeeDao;
import com.luv2code.springdemo.curddemo.entity.Employee;
import com.luv2code.springdemo.curddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService EmployeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService)
	{
		EmployeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return EmployeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		Employee theemployeeId = EmployeeService.findById(employeeId);
		
		if(theemployeeId == null)
		{
			throw new RuntimeException("Employee not found");
		}
		
		return theemployeeId;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theemployee)
	{
		theemployee.setId(0);
		
		EmployeeService.save(theemployee);
		
		return theemployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theemployee)
	{
		
		EmployeeService.save(theemployee);
		
		return theemployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		Employee theemployeeId = EmployeeService.findById(employeeId);
		
		if(theemployeeId == null)
		{
			throw new RuntimeException("Employee not found");
		}
		
		EmployeeService.deleteById(employeeId);
		
		return "Deleted Id : " + employeeId;
	}
	

}
