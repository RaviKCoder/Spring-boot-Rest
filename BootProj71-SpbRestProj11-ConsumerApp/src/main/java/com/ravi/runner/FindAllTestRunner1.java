package com.ravi.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.ravi.BootProj71SpbRestProj11ConsumerAppApplication;
import com.ravi.vo.TravellerVO;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

//@Component
public class FindAllTestRunner1 implements CommandLineRunner {

    private final BootProj71SpbRestProj11ConsumerAppApplication bootProj71SpbRestProj11ConsumerAppApplication;
	
	@Autowired
	private RestTemplate template;

    FindAllTestRunner1(BootProj71SpbRestProj11ConsumerAppApplication bootProj71SpbRestProj11ConsumerAppApplication) {
        this.bootProj71SpbRestProj11ConsumerAppApplication = bootProj71SpbRestProj11ConsumerAppApplication;
    }

	@Override
	public void run(String... args) throws Exception {
		
		//base url
		String url="http://localhost:8082/BootProj70-SpbRestProj10-APIDevelopment-MiniProject-Swagger/traveller-api/getAll";

		//invoke the endpoint
		ResponseEntity<String> resp = template.exchange(url, HttpMethod.GET, null, String.class);
		
		System.out.println("Result is: "+resp.getBody());
		System.out.println("Status code: "+resp.getStatusCode());
		System.out.println("headers: "+resp.getHeaders());
		
		
		System.out.println("==============================");
		
		//convert String JSON content to List<TravellerVO> object
		
		ObjectMapper mapper = new ObjectMapper();
		List<TravellerVO> listVO = mapper.readValue(resp.getBody(), new TypeReference<List<TravellerVO>>() {});
		listVO.forEach(System.out::println);
		
		//exit the flow
		System.exit(0);
	}

}
