package com.company.project.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.domain.Post;
import com.company.project.resources.util.URL;
import com.company.project.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);		
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);			
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> findByTextAndMomentInterval(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minMoment", defaultValue = "") String minMoment,
			@RequestParam(value = "maxMoment", defaultValue = "") String maxMoment) {
		text = URL.decodeParam(text);
		Instant min = URL.convertMoment(minMoment, Instant.EPOCH);
		Instant max = URL.convertMoment(maxMoment, Instant.now());
		List<Post> list = service.findByTextAndMomentInterval(text, min, max);		
		return ResponseEntity.ok().body(list);		
	}
}
