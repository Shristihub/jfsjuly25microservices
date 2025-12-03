package com.greeterservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeterservice.service.IMessengerService;

@RestController
public class GreetController {
	
	@Autowired
	private IMessengerService messengerService;
	
	@GetMapping("/message")
	String showMessage(){
		return messengerService.showMessage();
	}
	
	

//	http://localhost:8081/greeter/username/priya
	@GetMapping("/greeter/username/{username}")
	ResponseEntity<String> greetUser(@PathVariable String username) {
		String msg = "Have a great day " + username;
		return ResponseEntity.ok(msg);
	}
//	http://localhost:8081/greeter/show-books
	@GetMapping("/greeter/show-books")
	ResponseEntity<List<String>> showBooks() {
		return ResponseEntity.ok(Arrays.asList("Java", "Spring"));
	}

//	http://localhost:8081/greeter/print/userdetails?username=Priya
	@GetMapping("/greeter/print/userdetails")
	ResponseEntity<String> printDetails(@RequestParam String username) {
		String msg = "Welcome " + username;
		return ResponseEntity.ok(msg);
	}

	
	
	
}
