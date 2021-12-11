package com.greatlearing.customerrelationshipmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearing.customerrelationshipmanagement.entities.Customers;
import com.greatlearing.customerrelationshipmanagement.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService  customerService;
	
	//add mapping for list
	@RequestMapping("/list")
	public String listCustomer(Model theModel)
	{
		System.out.println("Request recived");
		
		//get record from database
		List<Customers> theCustomer=customerService.findAll();
		
		//add to the spring model
		theModel.addAttribute("Customers", theCustomer);
		
		return "customer-list";
		
	}
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create model attribute to bind form data
		Customers theCustomer=new Customers();
		
		theModel.addAttribute("Customers", theCustomer);

		return "customer-form";
		
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		//get the student from service
		Customers theCustomer= customerService.findById(theId);
		
		//set student as a model attribute to pre-populate the form
		theModel.addAttribute("Customers", theCustomer);
		
		//send over to our form
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,@RequestParam("lastName")String lastName,@RequestParam("email") String email)
	{
		System.out.println(id);
		Customers theCustomer;
		if(id!=0) {
			theCustomer=customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
			
		}
		else
			theCustomer=new Customers(firstName,lastName,email);
		//save the students
		customerService.save(theCustomer);
		//use a redirect to prevent duplicate submission
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		//delete the book 
		customerService.deleteById(theId);
		//redirect to/student/list
		return "redirect:/customer/list";
	}
	
	
}
