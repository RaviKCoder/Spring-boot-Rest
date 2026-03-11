package com.ravi.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.ravi.BootProj71SpbRestProj11ConsumerAppApplication;
import com.ravi.vo.TravellerVO;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Component
public class DeleteByBudgetRangeTestRunner1 implements CommandLineRunner {
	
	@Autowired
	private RestTemplate template;

 

	@Override
	public void run(String... args) throws Exception {
		
		//base url
		String url="http://localhost:8082/BootProj70-SpbRestProj10-APIDevelopment-MiniProject-Swagger/traveller-api/delete/{startBudget}/{endBudget}";

				//invoke the endpoint
		ResponseEntity<String> resp = template.exchange(url, HttpMethod.DELETE, null, String.class,40000.0,50000.0);
		
		System.out.println("Result is: "+resp.getBody());
		System.out.println("Status code: "+resp.getStatusCode());
		System.out.println("headers: "+resp.getHeaders());
		
		
		System.out.println("==============================");
		
		
		//exit the flow
		System.exit(0);
	}

}
