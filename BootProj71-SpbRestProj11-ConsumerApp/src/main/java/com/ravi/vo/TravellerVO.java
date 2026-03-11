package com.ravi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TravellerVO {
	
	//data property
	
	private Integer tid;
	
	@NonNull
	private String tname;
	
	@NonNull
	private String taddrs;
	
	@NonNull
	private String startPlace;
	
	@NonNull
	private String destPlace;
	
	@NonNull 
	private Double budget;
	
	
	

}
