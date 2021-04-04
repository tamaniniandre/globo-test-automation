package com.globo.test.automation.webservice.services;

import com.globo.test.automation.dto.User;
import com.globo.test.automation.utils.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

public class UsuarioService {

    private static final String baseUri = PropertiesFile.readPropertiesFile().getProperty("base_uri");
    private static final String usuarioUri = PropertiesFile.readPropertiesFile().getProperty("usuarios_uri");

    public static void postUser(User user){
        SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri)
                .body(user)
                .post(usuarioUri)
        ;
    }

}
