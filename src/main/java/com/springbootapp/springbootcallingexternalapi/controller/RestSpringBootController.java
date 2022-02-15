package com.springbootapp.springbootcallingexternalapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/films")
public class RestSpringBootController {

	String url = "https://swapi.dev/api/films/";
	RestTemplate restTemplate = new RestTemplate();
	String title = restTemplate.getForObject(url, String.class);
	
	@GetMapping
	public ResponseEntity<String> getAllFilms(){
		return ResponseEntity.ok().body(title);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<String> getFilms(@PathVariable Long id){

		url += id;
		title = restTemplate.getForObject(url, String.class);
		return ResponseEntity.ok(title);
		
	}
	
	
}
