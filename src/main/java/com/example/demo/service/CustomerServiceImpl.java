package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Customer;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private final CustomerRepository customerRepository;
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	

	@Override
	public Customer getOne(Long id) {
		log.info("getOne service");
		Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
		if(customerEntity.isPresent()) {
			CustomerEntity entity = customerEntity.get();
			return getCustomerDTOFromEntity(entity);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}

	private Customer getCustomerDTOFromEntity(CustomerEntity entity) {
		return new Customer(entity.getId(), entity.getFirstName(), entity.getLastName(), 
				entity.getAddressline1(), entity.getAddressline2(), entity.getCity(), 
				entity.getState(), entity.getZip(), entity.getCountry());
	}
	
	private CustomerEntity getCustomerEntityFromDTO(Customer dto) {
		CustomerEntity entity = new CustomerEntity();
		setCustomerEntity(dto, entity);
		return entity;	
	}


	private void setCustomerEntity(Customer dto, CustomerEntity entity) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setAddressline1(dto.getAddressline1());
		entity.setAddressline2(dto.getAddressline2());
		entity.setCity(dto.getCity());
		entity.setState(dto.getState());
		entity.setZip(dto.getZip());
		entity.setCountry(dto.getCountry());
	}
	
	
	@Override
	public List<Customer> getAll() {
		log.info("getAll service");
		List<CustomerEntity> list = customerRepository.findAll();
		List<Customer> customers = new ArrayList<>();
		for(CustomerEntity entity : list) {
			customers.add(getCustomerDTOFromEntity(entity));
		}
		return customers;
	}

	@Override
	public Customer create(Customer customer) {
		log.info("create service");
		CustomerEntity entity = customerRepository.save(getCustomerEntityFromDTO(customer));
		return getCustomerDTOFromEntity(entity);
	}

	@Override
	public Customer update(Long id, Customer customer) {
		log.info("update service");
		Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
		if(customerEntity.isPresent()) {
			CustomerEntity entity = customerEntity.get();
			setCustomerEntity(customer, entity);
			customerRepository.save(entity);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
		return customer;
	}

	@Override
	public void delete(Long id) {
		log.info("delete service");
		Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
		if(customerEntity.isPresent()) {
			customerRepository.delete(customerEntity.get());
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
		
	}

}
