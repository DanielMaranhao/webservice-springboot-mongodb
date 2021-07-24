package com.company.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.company.project.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
