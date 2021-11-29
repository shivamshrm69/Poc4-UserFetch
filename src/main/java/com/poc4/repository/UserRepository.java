package com.poc4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc4.entity.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}
