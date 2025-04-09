package com.school.school.models;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "events")
public class Event {
    @Id @Getter @Setter private String id;
    @Getter @Setter private String title;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String date;
    
    Event(){}

    public Event(String id, String title, String name, String description, String date) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.description = description;
        this.date = date;
    }

}
