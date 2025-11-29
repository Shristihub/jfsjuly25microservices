package com.callerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallerServiceImpl implements ICallerService{
	
	@Autowired
	private RestTemplate template;
	
	private final String BASEURL= "http://greet-service/greeter";

	//call printdetails
	@Override
	public String printUserDetails(String username) {
//		http://localhost:8081/greeter/print/userdetails?username=Priya
		String url = BASEURL.concat("/print/userdetails?username=").concat(username);
		ResponseEntity<String> responseEntity = template.getForEntity(url, String.class);
		System.out.println(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}

	@Override
	public String welcomeUserDetails(String name) {
//		http://localhost:8081/greeter/username/priya
		String url = BASEURL.concat("/username/").concat(name);
		ResponseEntity<String> responseEntity = template.getForEntity(url, String.class);
		System.out.println(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}

	@Override
	public List<String> showBooks() {
//		http://localhost:8081/greeter/show-books
		String url = BASEURL.concat("/show-books");
		ResponseEntity<List<String>> responseEntity = (ResponseEntity)template.getForEntity(url,List.class);
		return responseEntity.getBody();
	}

}








