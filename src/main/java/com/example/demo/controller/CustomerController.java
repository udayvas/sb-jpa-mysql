package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Customer;
import com.example.demo.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class CustomerController {

	@Autowired
	private final CustomerService customerService;
	
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer){
		log.info("create controller");
		return ResponseEntity.ok().body(customerService.create(customer));
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> udpate(@PathVariable Long id, @RequestBody Customer customer){
		log.info("udpate controller");
		return ResponseEntity.ok().body(customerService.update(id, customer));
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAll(){
		log.info("getAll controller");
		return ResponseEntity.ok().body(customerService.getAll());
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getOne(@PathVariable Long id){
		log.info("getOne controller");
		return ResponseEntity.ok().body(customerService.getOne(id));
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		log.info("delete controller");
		customerService.delete(id);		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("success");
	}
	
}

