package com.qa.contract.consumermicroservice;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.restassured.RestAssured.given;

@RestController
public class ControllerLayer {


    @GetMapping(value = "/check", produces = "application/json")
    public String checkNumberType(@RequestParam("number") int number) {

        Response response = given()
                .baseUri("http://localhost:8090/math/type")//Consuming Provider service which should be running in provider-micro-service project
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("number", number).get();
        //http://localhost:8090/check?number=9
        return response.asString();
    }
}
