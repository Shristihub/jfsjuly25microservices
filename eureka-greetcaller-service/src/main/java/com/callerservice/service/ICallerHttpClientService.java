package com.callerservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "http://greet-service")
public interface ICallerHttpClientService {
	
//	http://localhost:8081/greeter/username/priya
	@GetExchange("/greeter/username/{username}")
	ResponseEntity<String> greetUserClient(@PathVariable String username);
	
//	http://localhost:8081/greeter/show-books
	@GetExchange("/greeter/show-books")
	ResponseEntity<List<String>> showBooksClient();
	
//	http://localhost:8081/greeter/print/userdetails?username=Priya
	@GetExchange("/greeter/print/userdetails")
	ResponseEntity<String> printDetailsClient(@RequestParam String username);

}
