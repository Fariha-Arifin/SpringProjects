package com.luv2code.springdemo.curddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.curddemo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	@Autowired 
	public EmployeeDaoHibernateImpl(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);   
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
        Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class, theId);   
		
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId"); 
		
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
		
		
	}

}
