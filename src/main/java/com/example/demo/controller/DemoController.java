package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/members/{name}")
	public String getMembers(@PathVariable("name") String name) {
		return name;
	}
}
