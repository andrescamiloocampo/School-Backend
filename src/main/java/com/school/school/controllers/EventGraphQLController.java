package com.school.school.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.school.school.models.Event;
import com.school.school.repositories.EventRepository;

@Controller
public class EventGraphQLController {
    
    private final EventRepository eventRepository;

    EventGraphQLController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @QueryMapping
    public List<Event> allEvents() {                
        return eventRepository.findAll();
    }
}
