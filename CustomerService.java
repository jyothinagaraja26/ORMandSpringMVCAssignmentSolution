package com.greatlearing.customerrelationshipmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearing.customerrelationshipmanagement.entities.Customers;

@Service
public interface CustomerService {

	public List<Customers> findAll();

	public Customers findById(int theId);

	public void save(Customers theCustomer);

	public void deleteById(int theId);
	
	
}
