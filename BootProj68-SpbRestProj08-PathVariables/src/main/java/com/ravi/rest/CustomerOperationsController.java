package com.ravi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
//	@GetMapping("/data/{cno}/{cname}")
//	public ResponseEntity<String> processData(@PathVariable("cno") Integer no,@PathVariable("cname") String name){
//		System.out.println(no+"--------"+name);
//		//return ResponseEntity
//		return new ResponseEntity<String>(no+"------"+name, HttpStatus.OK);
//	}
	
//	@GetMapping("/data/{no}/{name}")
//	public ResponseEntity<String> processData(@PathVariable Integer no, @PathVariable String name){
//		System.out.println(no+"--------"+name);
//		//return ResponseEntity
//		return new ResponseEntity<String>(no+"------"+name, HttpStatus.OK);
//	}
	
//	@GetMapping("/data/{no}/{name}")
//	public ResponseEntity<String> processData(@PathVariable  Integer no,@PathVariable  String name){
//		System.out.println(no+"--------"+name);
//		//return ResponseEntity
//		return new ResponseEntity<String>(no+"------"+name, HttpStatus.OK);
//	}
	
	@GetMapping({"/data/{no}/{name}","/data/{no}","/data"})
	public ResponseEntity<String> processData(@PathVariable(required = false)  Integer no,@PathVariable(required = false)  String name){
		System.out.println(no+"--------"+name);
		//return ResponseEntity
		return new ResponseEntity<String>(no+"------"+name, HttpStatus.OK);
	}
	
	



}
