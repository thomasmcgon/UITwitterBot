package com.testframework;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class TwitterAccount {
    private String email;
    private String password;
    private String username;

    public TwitterAccount() throws IOException {
        JsonReader reader = new JsonReader();
        String jsonString = reader.readInData();
        JsonNode node = reader.parse(jsonString);
        this.email = node.get("email").asText();
        this.password = node.get("password").asText();
        this.username = node.get("username").asText();
    }

    public String getEmail() {
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getUsername(){
        return username;
    }

}
