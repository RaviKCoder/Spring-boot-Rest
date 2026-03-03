package com.ravi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
//	@GetMapping("/data")
//	public ResponseEntity<String> processData(@RequestParam("cno") Integer no,@RequestParam("cname") String name){
//		System.out.println(no+"--------"+name);
//		//return ResponseEntity
//		return new ResponseEntity<String>(no+"------"+name, HttpStatus.OK);
//	}
	
//	@GetMapping("/data")
//	public ResponseEntity<String> processData(@RequestParam() Integer no,@RequestParam() String name){
//		System.out.println(no+"--------"+name);
//		//return ResponseEntity
//		return new ResponseEntity<String>(no+"------"+name, HttpStatus.OK);
//	}
	
	@GetMapping("/data")
	public ResponseEntity<String> processData(@RequestParam(required = false) Integer no,@RequestParam(required = false,defaultValue = "RRR") String name){
		System.out.println(no+"--------"+name);
		//return ResponseEntity
		return new ResponseEntity<String>(no+"------"+name, HttpStatus.OK);
	}



}
