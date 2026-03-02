package com.ravi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ravi.model.Company;
import com.ravi.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
	@PostMapping("/register-company")
	public ResponseEntity<String> registerCompany(@RequestBody Company company) {
		System.out.println("Model class object data: "+company);
		
		//return ResponseEntity object
		return new ResponseEntity<String>(company.toString(),HttpStatus.OK);
	}

	
	@PostMapping("/register-customer")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
		System.out.println("Model class object data: "+customer);
		
		//return ResponseEntity object
		return new ResponseEntity<String>(customer.toString(),HttpStatus.OK);
	}

}
