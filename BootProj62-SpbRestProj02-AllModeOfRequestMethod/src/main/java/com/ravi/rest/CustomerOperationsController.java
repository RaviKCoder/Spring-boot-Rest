package com.ravi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
	@PostMapping("/add")
	public ResponseEntity<String> registerCustomer(){
		return new ResponseEntity<String>("Customer Added",HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<String> showCustomer(){
		return new ResponseEntity<String>("Customer are selected",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(){
		return new ResponseEntity<String>("Customer updated",HttpStatus.OK);
	}
	
	@PatchMapping("/updateEmail")
	public ResponseEntity<String> updateCustomerEmail(){
		return new ResponseEntity<String>("Customer email updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(){
		return new ResponseEntity<String>("Customer deleted",HttpStatus.OK);
	}

}
