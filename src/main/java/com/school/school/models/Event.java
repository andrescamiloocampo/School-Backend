package com.school.school.models;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "events")
public class Event {
    @Id private String id;
    private String title;
    private String name;
    private String description;
    private String date;    
}
