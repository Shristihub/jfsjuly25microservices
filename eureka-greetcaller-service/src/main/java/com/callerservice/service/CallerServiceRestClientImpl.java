package com.callerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CallerServiceRestClientImpl implements ICallerService{
	
	@Autowired
	private RestClient restClient;
	

	//call printdetails
	@Override
	public String printUserDetails(String name) {
//		http://localhost:8081/greeter/print/userdetails?username=Priya&city=Chennai
	 return	restClient
		 .get()
		 .uri("http://localhost:8081/greeter/print/userdetails?username={username}", name)
		 .retrieve()
		 .body(String.class);

	}

	@Override
	public String welcomeUserDetails(String name) {
//		http://localhost:8081/greeter/username/priya
//		ResponseEntity<String> responseEntity = restClient
//				String uderDetails = restClient
//						 .get()
//						 .uri("http://localhost:8081/greeter/username/",name)
//						 .retrieve()
//						 .body(String.class)
//						 .toEntity(new ParameterizedTypeReference<>() {});
//						return responseEntity.getBody();
//		
		String userDetails = restClient
				 .get()
				 .uri("http://localhost:8081/greeter/username/{username}",name)
				 .retrieve()
				 .body(String.class);
			return userDetails;
		
	
	}

	@Override
	public List<String> showBooks() {
//		http://localhost:8081/greeter/show-books
		ResponseEntity<List<String>> responseEntity = restClient
		 .get()
		 .uri("http://greet-service/greeter/show-books")
		 .retrieve()
		 .toEntity(new ParameterizedTypeReference<>() {});
		return responseEntity.getBody();
	}
	
	
}








