package com.ravi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.service.ITravellerMgmtService;
import com.ravi.vo.TravellerVO;

//import io.swagger.v3.oas.annotations.Operation;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/traveller-api")
//@Tag(name = "Traveller API", description = "Operations related to Traveller Registration")
public class TravellerOperationsRestController {

	@Autowired
	ITravellerMgmtService travellerService;

	@PostMapping("/save")
	public ResponseEntity<String> registerTraveller(@RequestBody TravellerVO vo){
	
		try {
			//use service
			String msg = travellerService.registerTraveller(vo);
			
			//return ResponseEntity Object
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
			
			
		}catch (Exception e) {
			return new ResponseEntity<String>("problem: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

//	@PostMapping("/save")
//	public ResponseEntity<String> registerTraveller(@RequestBody TravellerVO vo) {
//
//		// use service
//		String msg = travellerService.registerTraveller(vo);
//
//		// return ResponseEntity Object
//		return new ResponseEntity<String>(msg, HttpStatus.OK);
//
//	}
	
	
	

//    @Operation(
//        summary = "Register a new Traveller",
//        description = "This API is used to register a traveller with travel details like start place, destination and budget."
//    )
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Traveller registered successfully"),
//        @ApiResponse(responseCode = "400", description = "Invalid input data"),
//        @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
//    
//    @PostMapping("/save")
//	public ResponseEntity<String> registerTraveller(@RequestBody TravellerVO vo) {
//
//		// use service
//		String msg = travellerService.registerTraveller(vo);
//
//		// return ResponseEntity Object
//		return new ResponseEntity<String>(msg, HttpStatus.OK);
//
//	}
	
	
	
	

	@PostMapping("/saveAll")
	public ResponseEntity<String> registerMultipleTravellers(@RequestBody List<TravellerVO> vo) {
		// use service
		String msg = travellerService.registerTravellers(vo);
		
		// return new ResponseEntity object
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TravellerVO>> getAllTravellers(){
		//use service
		List<TravellerVO> listVO = travellerService.showAllTravellers();
		
		if(listVO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listVO,HttpStatus.OK);
	}
	
	@GetMapping("/find/{ids}")
	public ResponseEntity<List<TravellerVO>> getAllTravellersByIds(@PathVariable   List<Integer> ids){
		
		//use service
		List<TravellerVO> allTravellersByIds = travellerService.showAllTravellersByIds(ids);
		
		if(allTravellersByIds.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(allTravellersByIds);
	}
	
	@GetMapping("/find/{start}/{end}")
	public ResponseEntity<List<TravellerVO>> getTravellerByBudgetRange(@PathVariable("start") Double startRange,@PathVariable("end") Double endRange){
		
		//user service
		List<TravellerVO> listVO = travellerService.getTravellersByBudgetRange(startRange, endRange);
		
		return ResponseEntity.ok(listVO);
	}
	
	@GetMapping("/findOne/{id}")
	public ResponseEntity<TravellerVO> getTravellerById(@PathVariable Integer id) {
		
		//use service
		TravellerVO vo = travellerService.getTravellerById(id);
		
		return ResponseEntity.ok(vo);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTraveller(@RequestBody TravellerVO vo){
		//use service
		String msg = travellerService.updateTraveller(vo);
	
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/update/{tid}/{discount}")
	public ResponseEntity<String> updateTravellerBudget(@PathVariable  Integer tid, @PathVariable Double discount){
		//user service
		String msg = travellerService.updateTeavellerBudget(tid, discount);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTravellerById(@PathVariable Integer id){
		//use service
		String msg = travellerService.deleteTravellerById(id);
	
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{startBudget}/{endBudget}")
	public ResponseEntity<String> removeTravellerByBudgetRange(@PathVariable Double startBudget,@PathVariable Double endBudget){
		//use service
		String msg = travellerService.deleteTravelerByBudgetRange(startBudget, endBudget);
	
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
