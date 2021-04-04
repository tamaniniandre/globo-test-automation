package com.globo.test.automation.hooks;

import com.globo.test.automation.webservice.jsons.LoginJsons;
import com.globo.test.automation.webservice.jsons.UserJsons;
import com.globo.test.automation.webservice.services.LoginService;
import com.globo.test.automation.webservice.services.UsuarioService;
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
            UsuarioService.postUser(UserJsons.generateUser());
            LoginService.doLoginService(LoginJsons.loginUserDefaultJson());
            isLogged = true;
        }
    }

}
