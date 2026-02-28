package com.ravi.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
	//simple properties
	@NonNull
	private Integer cno;
	@NonNull
	private String cname;
	@NonNull
	private String addrs;
	@NonNull
	private Double billAmount;
	
	//array properties
	private String[] favColor;
	private List<String> friends;
	private Set<Long> phones;
	private Map<String, Object> idDetails;
	
	//HAS-A Property
	private Company company;

}
