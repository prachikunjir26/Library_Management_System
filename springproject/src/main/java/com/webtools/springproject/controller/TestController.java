package com.webtools.springproject.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Component
@RestController
public class TestController {
	
	@GetMapping("/try")
	public String Test() {
		
		return "It's okay you";
	}
}
