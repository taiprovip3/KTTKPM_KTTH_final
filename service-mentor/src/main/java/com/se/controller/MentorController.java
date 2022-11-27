package com.se.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.Mentor;
import com.se.repository.MentorRepository;

@RestController
@RequestMapping("/service_mentor")
public class MentorController {
	
	@Autowired
	private MentorRepository mentorRepository;

	@GetMapping("/getById/{id}")
	public Mentor getMentoryById(@PathVariable long id) {
		Optional<Mentor> mentorO = mentorRepository.findById(id);
		if(mentorO.isPresent()) {
			Mentor m = mentorO.get();
			return m;
		}
		return null;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/generateMentor")
	public String generateMentor() {
		for (int i = 51; i < 300; i++) {
			Mentor m = new Mentor();
			m.setId(i);
			m.setName("Mentor name " + i);
			m.setAddress("Mentor address " + i);
			mentorRepository.save(m);
		}
		return "generate success";
	}
	
	@GetMapping("/getAllMentor")
	@CachePut(value = "Mentors_Hash")
	public List<Mentor> getMentors(){
		return mentorRepository.findAll();
	}
	
}
