package com.globo.test.automation.webservice.services;

import com.globo.test.automation.utils.PropertiesFile;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

public class LoginService {

    private static final String baseUri = PropertiesFile.readPropertiesFile().getProperty("base_uri");
    private static final String loginUri = PropertiesFile.readPropertiesFile().getProperty("login_uri");

    public static void doLoginService(JsonObject jsonObject){
        Response response = SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri)
                .body(jsonObject.toString())
                .post(loginUri)
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        String token = response.path("authorization");
        Serenity.setSessionVariable("token").to(token);
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .build().header("Authorization", token);

    }

}
