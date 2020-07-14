package com.example.test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.model.HelloBean;

@RestController
public class Controller {
	
	@GetMapping("/hello")
	public HelloBean hello() {
		return new HelloBean("title","article","The Hindu","14 july 2020");
	}

}
