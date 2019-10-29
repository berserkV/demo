package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public String getMember(@PathVariable("name") String name) {
		return name;
	}
	
	@GetMapping("/members/all")
	public List<String> getMembers() {
		return new ArrayList<>(Arrays.asList("Diego", "Maheli", "Dulce"));
	}
}
