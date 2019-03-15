package com.demo.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	


	@GetMapping("/hi")
	public String home() {
		return "hi";
	}

	@GetMapping("/health")
	public String health() {
		return "hello consul";
	}
}