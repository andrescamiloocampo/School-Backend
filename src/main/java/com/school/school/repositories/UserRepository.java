package com.school.school.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.school.models.User;

public interface UserRepository extends MongoRepository<User,String>{    
}
