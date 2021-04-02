package com.globo.test.automation.hooks;

import com.globo.test.automation.webservice.jsons.LoginJsons;
import com.globo.test.automation.webservice.services.LoginService;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.serenitybdd.core.Serenity;

public class HooksWs {

    private static boolean isLogged = false;

    @Before("@ServiceTests")
    public void beforeServiceTestS(){
        if(!isLogged) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
            LoginService.doLoginService(LoginJsons.loginUserDefaultJson());
            isLogged = true;
        }
    }

}
