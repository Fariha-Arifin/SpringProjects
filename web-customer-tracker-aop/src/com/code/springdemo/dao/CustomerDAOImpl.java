package com.code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> thequery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		List<Customer> customers = thequery.getResultList();
		
		System.out.println("List of customers" + customers);
		
		
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer thecustomer) {
		
        Session currentSession = sessionFactory.getCurrentSession();
		
        currentSession.saveOrUpdate(thecustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		 Session currentSession = sessionFactory.getCurrentSession();
		 
		 Customer thecustomer = currentSession.get(Customer.class, theId);
		 
		return thecustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		 
		Query thequery = currentSession.createQuery("delete from Customer where id=:customerId");
		thequery.setParameter("customerId", theId);
		thequery.executeUpdate();
		
	}

}
