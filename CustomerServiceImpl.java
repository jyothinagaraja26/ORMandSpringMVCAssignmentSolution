package com.greatlearing.customerrelationshipmanagement.service;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearing.customerrelationshipmanagement.entities.Customers;



@Repository
public class CustomerServiceImpl implements CustomerService{

	private SessionFactory sessionFactory;
	// create session
	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	@Transactional
	@Override
	public List<Customers> findAll() {
		// TODO Auto-generated method stub
		Transaction tx= session.beginTransaction();
		// find all the records from the database table
		List<Customers> customers = session.createQuery("from Customers").list();
		tx.commit();
		return customers;
	}

	@Transactional
	@Override
	public Customers findById(int theId) {
		// TODO Auto-generated method stub
		Customers customers=new Customers();
		Transaction tx= session.beginTransaction();
		// find record with id from the database table
				customers = session.get(Customers.class, theId);
		tx.commit();
		return customers;
	}

	@Transactional
	@Override
	public void save(Customers theCustomer) {
		Transaction tx= session.beginTransaction();
		// save transaction
		session.save(theCustomer);
		tx.commit();
		
		
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Transaction tx= session.beginTransaction();
		//get transaction
		Customers customers=session.get(Customers.class,theId );
		//delete customer record
		session.delete(customers);
		tx.commit();
		
	}

}
