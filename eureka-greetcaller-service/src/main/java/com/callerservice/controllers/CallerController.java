package com.callerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.callerservice.service.ICallerService;

@RestController
public class CallerController {

	@Autowired
	@Qualifier(value = "callerServiceRestClientImpl")
	private ICallerService callerService;
	
	
	
	@GetMapping("/user-details/{username}")
	ResponseEntity<String> getUserDetails(@PathVariable String username){
		return ResponseEntity.ok(callerService.printUserDetails(username));
		
	}
	
	
	@GetMapping("/view-books")
	ResponseEntity<List<String>> getAllBooks(){
		return ResponseEntity.ok(callerService.showBooks());
		
	}
	@GetMapping("/welcome-user/{username}")
	ResponseEntity<String> welcomeUser(@PathVariable String username) {
		return ResponseEntity.ok(callerService.welcomeUserDetails(username));
	}
	
}
