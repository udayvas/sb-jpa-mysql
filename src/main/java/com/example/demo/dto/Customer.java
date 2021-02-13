package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.errors.ValidationUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

	private long id;
	
	@NotNull
	@Pattern(regexp = ValidationUtil.ALPHA_NUMERIC, message = "{firstName.notempty}")
	@Size(min = 1, max = 35)
	@JsonProperty("firstName")
	private String firstName;
	
	@NotNull
	@Pattern(regexp = ValidationUtil.ALPHA_NUMERIC, message = "{lastName.notempty}")
	@Size(min = 1, max = 35)
	@JsonProperty("lastName")
	private String lastName;
	
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String zip;
	private String country;
}
