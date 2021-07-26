package com.company.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.company.project.domain.Post;
import com.company.project.domain.User;
import com.company.project.dto.AuthorDTO;
import com.company.project.dto.CommentDTO;
import com.company.project.repositories.PostRepository;
import com.company.project.repositories.UserRepository;
import com.company.project.resources.util.TimeUtil;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");	
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Post p1 = new Post(null, TimeUtil.toInstant("2018-03-21"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));		
		Post p2 = new Post(null, TimeUtil.toInstant("2018-03-23"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", TimeUtil.toInstant("2018-03-21"), new AuthorDTO(u2));
		CommentDTO c2 = new CommentDTO("Aproveite", TimeUtil.toInstant("2018-03-22"), new AuthorDTO(u3));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", TimeUtil.toInstant("2018-03-23"), new AuthorDTO(u2));
		
		p1.getComments().addAll(Arrays.asList(c1, c2));
		p2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		u1.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(u1);
	}
}
