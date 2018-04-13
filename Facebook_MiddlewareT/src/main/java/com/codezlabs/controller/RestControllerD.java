package com.codezlabs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerD {

	
	

	@RequestMapping("/test")
	public String home()
	{
		
		return "test";
	}
}
