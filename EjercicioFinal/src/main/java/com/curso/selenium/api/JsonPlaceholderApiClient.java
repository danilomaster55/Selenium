package com.curso.selenium.api;

import io.restassured.response.Response;
import java.util.Map;

public class JsonPlaceholderApiClient extends BaseApi {

    public JsonPlaceholderApiClient() {
        super("https://jsonplaceholder.typicode.com");
    }

    // GET: Ontener user por ID
    public Response getUser(int userId) {
        return request().get("/users/" + userId);
    }

    // POST: Crear un nuevo usuario (en JSONPlaceholder)
    public Response createUser(Map<String, Object> userData) {
        return request().body(userData).post("/users");
    }

    // PUT: Actualizar un usuario existente
    public Response updateUser(int userId, Map<String, Object> userData) {
        return request().body(userData).put("/users/" + userId);
    }
}
