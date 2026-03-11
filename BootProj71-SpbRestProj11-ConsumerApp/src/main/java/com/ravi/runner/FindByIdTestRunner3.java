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
public class FindByIdTestRunner3 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
	 //url
	 String url="http://localhost:8082/BootProj70-SpbRestProj10-APIDevelopment-MiniProject-Swagger/traveller-api/findOne/{id}";
	 
	 //invoke the endpoint
	ResponseEntity<String> resp = template.exchange(url, HttpMethod.GET, null, String.class, 1004);
	
	//get the result
		String resp_body = resp.getBody();
		Integer status_code=resp.getStatusCode().value();
		HttpHeaders headers = resp.getHeaders();
		
		System.out.println("Result is: "+resp_body);
		System.out.println("Response status code: "+status_code);
		System.out.println("REsponse headers: "+headers);
		
		System.out.println("===============================");
		
		//converting String JSON content to JAVA class object
		ObjectMapper mapper = new ObjectMapper();
		TravellerVO vo = mapper.readValue(resp_body,TravellerVO.class);
		System.out.println("VO class object: "+vo);
		
		System.exit(0);
	
	}

}
