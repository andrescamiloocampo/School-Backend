package com.school.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.school.models.Event;
import com.school.school.repositories.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping()
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }    

    @PostMapping("/new-event")
    public Event createEvent(@RequestBody Event event) {            
        return eventRepository.insert(event);
    }
}