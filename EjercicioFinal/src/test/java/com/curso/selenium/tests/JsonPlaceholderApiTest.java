package com.curso.selenium.tests;

import com.curso.selenium.api.JsonPlaceholderApiClient;
import com.curso.selenium.listeners.TestListener;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestListener.class)
public class JsonPlaceholderApiTest {

    private final JsonPlaceholderApiClient api = new JsonPlaceholderApiClient();

    @Test
    public void testGetUser() {
        Response response = api.getUser(2);

        TestListener.getTest().info("Response code: " + response.getStatusCode());
        TestListener.getTest().info("Response body: <pre>" + response.getBody().asPrettyString() + "</pre>");

        assertEquals(200, response.getStatusCode());
        assertEquals(2, response.jsonPath().getInt("id"));
    }

    @Test
    public void testCreateUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "John Doe");
        user.put("username", "johndoe");
        user.put("email", "john@example.com");

        Response response = api.createUser(user);

        TestListener.getTest().info("Response code: " + response.getStatusCode());
        TestListener.getTest().info("Response body: <pre>" + response.getBody().asPrettyString() + "</pre>");

        assertEquals(201, response.getStatusCode());
        assertEquals("John Doe", response.jsonPath().getString("name"));
        assertEquals("johndoe", response.jsonPath().getString("username"));
        assertEquals("john@example.com", response.jsonPath().getString("email"));
    }

    @Test
    public void testUpdateUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Jane Doe");
        user.put("username", "janedoe");
        user.put("email", "jane@example.com");

        Response response = api.updateUser(2, user);

        TestListener.getTest().info("Response code: " + response.getStatusCode());
        TestListener.getTest().info("Response body: <pre>" + response.getBody().asPrettyString() + "</pre>");

        assertEquals(200, response.getStatusCode());
        assertEquals("Jane Doe", response.jsonPath().getString("name"));
        assertEquals("janedoe", response.jsonPath().getString("username"));
        assertEquals("jane@example.com", response.jsonPath().getString("email"));
    }
}
