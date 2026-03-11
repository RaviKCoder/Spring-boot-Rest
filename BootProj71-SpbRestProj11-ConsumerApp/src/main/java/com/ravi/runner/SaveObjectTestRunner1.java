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

//@Component
public class SaveObjectTestRunner1 implements CommandLineRunner {

    private final BootProj71SpbRestProj11ConsumerAppApplication bootProj71SpbRestProj11ConsumerAppApplication;
	
	@Autowired
	private RestTemplate template;

    SaveObjectTestRunner1(BootProj71SpbRestProj11ConsumerAppApplication bootProj71SpbRestProj11ConsumerAppApplication) {
        this.bootProj71SpbRestProj11ConsumerAppApplication = bootProj71SpbRestProj11ConsumerAppApplication;
    }

	@Override
	public void run(String... args) throws Exception {
		
		//base url
		String url="http://localhost:8082/BootProj70-SpbRestProj10-APIDevelopment-MiniProject-Swagger/traveller-api/save";

		//prepare request header
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//convert java object as JSON content using jackson api
		TravellerVO vo=new TravellerVO("Suraj", "Kerla", "kerla", "Jharkhand", 5000.0);
		ObjectMapper mapper=new ObjectMapper();
		String body = mapper.writeValueAsString(vo);
		
		
		
//		String body="{\r\n"
//				+ "    \"tname\": \"Amit Sharma\",\r\n"
//				+ "    \"taddrs\": \"Delhi\",\r\n"
//				+ "    \"startPlace\": \"Delhi\",\r\n"
//				+ "    \"destPlace\": \"Manali\",\r\n"
//				+ "    \"budget\": 30000.00\r\n"
//				+ "  }";
		
		//prepare HttpEntity object representing headers and body
		HttpEntity<String> entity=new HttpEntity<String>(body,headers);
		
		//invoke the endpoint
		ResponseEntity<String> resp = template.exchange(url, HttpMethod.POST, entity, String.class);
		
		System.out.println("Result is: "+resp.getBody());
		System.out.println("Status code: "+resp.getStatusCode());
		System.out.println("headers: "+resp.getHeaders());
		
		
		System.out.println("==============================");
		
		
		//exit the flow
		System.exit(0);
	}

}
