package com.testframework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonReader {
    public String readInData() throws IOException {
        Path file = Path.of("src/main/resources/TwitterAccountInfo.json");
        String jsonString = Files.readString(file);
        return jsonString;
    }
    public JsonNode parse(String jsonString) throws JsonProcessingException {
        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.readTree(jsonString);
    }
}
