package com.school.school.services;

import java.net.URI;
import java.net.http.*;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class FlaskService {    
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();
    private String base_url = "http://localhost:5000";

    public String loginAndGetToken(String username, String password) throws Exception {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("username", username);
        requestBody.addProperty("password", password);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(base_url + "/login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(requestBody)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);
            return json.get("token").getAsString();
        } else {
            throw new RuntimeException("Error en login: " + response.body());
        }
    }    

    public boolean registerUser(String username, String password, String rol) throws Exception {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("username", username);
        requestBody.addProperty("password", password);
        requestBody.addProperty("rol", rol);
    
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(base_url + "/register"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(requestBody)))
                .build();
    
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
        return response.statusCode() == 201;
    }    
}
