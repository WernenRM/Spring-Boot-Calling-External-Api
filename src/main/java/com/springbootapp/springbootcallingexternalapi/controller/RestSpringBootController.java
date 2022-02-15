package com.springbootapp.springbootcallingexternalapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestSpringBootController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello world";
	}
	
	@GetMapping(value = "/callclienthello")
	public String getHelloClient(){
		String url = "http://localhost:8080/hello";
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(url, String.class);
		return result;
		
	}
	
	@GetMapping(value = "/films")
	public List<Object> getAllFilms(){
		String url = "https://swapi.dev/api/films/";
		RestTemplate restTemplate = new RestTemplate();
		
		String title = restTemplate.getForObject(url, String.class);
		return Arrays.asList(title);
		
	}
	
	@GetMapping(value = "/films/{id}/")
	public List<Object> getFilms(@PathVariable Long id){

		String url = "https://swapi.dev/api/films/ "+id+"/";
		RestTemplate restTemplate = new RestTemplate();
		
		String title = restTemplate.getForObject(url, String.class);
		return Arrays.asList(title);
		
	}
}
