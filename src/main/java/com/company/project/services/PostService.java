package com.company.project.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.domain.Post;
import com.company.project.repositories.PostRepository;
import com.company.project.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;	
	
	public Post findById(String id) {		
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));				
	}
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> findByTextAndMomentInterval(String text, Instant minMoment, Instant maxMoment) {
		maxMoment = maxMoment.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS).minus(1, ChronoUnit.NANOS);
		return repository.findByTextAndMomentInterval(text, minMoment, maxMoment);
	}
}
