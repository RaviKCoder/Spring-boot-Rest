package com.ravi.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ravi.BootProj63SpbRestProj03SendingJsonDataApplication;
import com.ravi.model.Company;
import com.ravi.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerRestOperations {

	private final BootProj63SpbRestProj03SendingJsonDataApplication bootProj63SpbRestProj03SendingJsonDataApplication;

	CustomerRestOperations(
			BootProj63SpbRestProj03SendingJsonDataApplication bootProj63SpbRestProj03SendingJsonDataApplication) {
		this.bootProj63SpbRestProj03SendingJsonDataApplication = bootProj63SpbRestProj03SendingJsonDataApplication;
	}

	@GetMapping("/cust-report")
	public ResponseEntity<Customer> showCustomerData() {

		System.out.println("CustomerRestOperations.showCustomerData()");

		// collect the data
		Customer cust = new Customer(1001, "Ravi", "Hud", 4563.0);

		return new ResponseEntity<Customer>(cust, HttpStatus.OK);

	}

	@GetMapping("/cust-all-report")
	public ResponseEntity<Customer> showCustomerAllData() {

		System.out.println("CustomerRestOperations.showCustomerAllData()");

		// collect the data
		Company company = new Company(1001, "HCL", "hyd", 400);
		Customer cust = new Customer(1001, "Ravi", "Hud", 4563.0);
		cust.setFavColor(new String[] { "red", "green", "yellow" });
		cust.setFriends(List.of("Rahul", "Smriti", "Ajay"));
		cust.setPhones(Set.of(547568489L, 67875665L, 87765764L));
		cust.setIdDetails(Map.of("aadhar", 5645643, "voterid", 6456789));
		cust.setCompany(company);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);

	}

//	@GetMapping("company-report-list")
//	public ResponseEntity<List<Company>> showAllCompanyData() {
//
//		System.out.println("CustomerRestOperations.showAllCompanyData()");
//		Company company1 = new Company(1001, "HCL", "HYD", 400);
//		Company company2 = new Company(1002, "Wipro", "blore", 500);
//		Company company3 = new Company(1003, "IBM", "pune", 600);
//
//		List<Company> list = List.of(company1, company2, company3);
//
//		return new ResponseEntity<List<Company>>(list, HttpStatus.CREATED);
//
//	}
	
	
	@GetMapping("company-report-list")
	public List<Company> showAllCompanyData() {

		System.out.println("CustomerRestOperations.showAllCompanyData()");
		Company company1 = new Company(1001, "HCL", "HYD", 400);
		Company company2 = new Company(1002, "Wipro", "blore", 500);
		Company company3 = new Company(1003, "IBM", "pune", 600);

		List<Company> list = List.of(company1, company2, company3);

		return list;

	}

}
