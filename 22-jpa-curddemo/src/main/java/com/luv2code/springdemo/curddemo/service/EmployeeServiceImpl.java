package com.luv2code.springdemo.curddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.curddemo.dao.EmployeeDao;
import com.luv2code.springdemo.curddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJPAimpl") EmployeeDao theEmployeeDao)
	{
		employeeDao = theEmployeeDao;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
		
	}

}
