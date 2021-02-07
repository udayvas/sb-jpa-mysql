package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private long id;
	private String firstName;
	private String lastName;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String zip;
	private String country;
}
