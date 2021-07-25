package com.company.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.company.project.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
