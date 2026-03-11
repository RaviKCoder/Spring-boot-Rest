package com.ravi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class FindByIdTestRunner2 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
	 //url
	 String url="http://localhost:8082/BootProj70-SpbRestProj10-APIDevelopment-MiniProject-Swagger/traveller-api/findOne/{id}";
	 
	 //invoke the endpoint
	String result=template.getForObject(url, String.class,1004);
	
	//get the result
	System.out.println("Result is : "+result);
	
	System.exit(0);
	
	}

}
