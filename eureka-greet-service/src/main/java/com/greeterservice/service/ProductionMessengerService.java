package com.greeterservice.service;

import org.springframework.beans.factory.annotation.Value;

public class ProductionMessengerService implements IMessengerService{

	@Value("${message}")
	private String message;

	@Override
	public String showMessage() {
		return message;
	}

}
