package com.callerservice.service;

import java.util.List;

public interface ICallerService {
	String printUserDetails(String username);
	String welcomeUserDetails(String username);
	List<String> showBooks();
}
