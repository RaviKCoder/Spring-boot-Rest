package com.ravi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ravi.vo.TravellerVO;

import tools.jackson.databind.ObjectMapper;

//@Component
public class FindByIdTestRunner4 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
	 //url
	 String url="http://localhost:8082/BootProj70-SpbRestProj10-APIDevelopment-MiniProject-Swagger/traveller-api/findOne/{id}";
	 
	 //invoke the endpoint
	ResponseEntity<TravellerVO> resp = template.exchange(url, HttpMethod.GET, null, TravellerVO.class, 1004);
	
	//get the result
		TravellerVO vo = resp.getBody();
		Integer status_code=resp.getStatusCode().value();
		HttpHeaders headers = resp.getHeaders();
		
		System.out.println("Result is: "+vo);
		System.out.println("Response status code: "+status_code);
		System.out.println("REsponse headers: "+headers);
		
		System.out.println("===============================");
		
		System.exit(0);
	
	}

}
