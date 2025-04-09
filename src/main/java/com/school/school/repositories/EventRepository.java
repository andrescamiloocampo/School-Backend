package com.school.school.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.school.models.Event;

public interface EventRepository extends MongoRepository<Event,String>{

}
