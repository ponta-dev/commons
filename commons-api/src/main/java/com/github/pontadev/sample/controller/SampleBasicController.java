package com.github.pontadev.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/sample")
public class SampleBasicController {

	@GetMapping(value = "/getSample")
	public String getSample() {
		return "sample";
	}
}
