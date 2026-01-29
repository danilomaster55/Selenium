package com.curso.selenium.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApi {
    protected String baseUrl;

    public  BaseApi(String baseUrl){
        this.baseUrl = baseUrl;
    }

    protected RequestSpecification request(){
        return RestAssured.given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .relaxedHTTPSValidation();
    }
}
