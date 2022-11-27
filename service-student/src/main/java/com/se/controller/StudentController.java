package com.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.se.entity.Mentor;

@RestController
@RequestMapping("/service_student")
public class StudentController {
	
	@Autowired
	private RestTemplate restTemplate;
	private final String SERVICE_MENTOR_URL = "http://localhost:8085/service_mentor/getById/";
	private int ATTEMP_RETRY = 1;
	
	@GetMapping("/getMentorOfStudent/{id}")
	public Mentor getMentor(@PathVariable long id) {
		Mentor m = restTemplate.getForObject(SERVICE_MENTOR_URL + id, Mentor.class);
		return m;
	}
	
	
	
}