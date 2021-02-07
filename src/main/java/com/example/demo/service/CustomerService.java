package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Customer;


public interface CustomerService {

	public Customer getOne(Long id);
	public List<Customer> getAll();
	public Customer create(Customer customer);
	public Customer update(Long id, Customer customer);
	public void delete(Long id);
}
