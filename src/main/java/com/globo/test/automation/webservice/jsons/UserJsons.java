package com.globo.test.automation.webservice.jsons;

import com.globo.test.automation.dto.User;
import com.globo.test.automation.utils.PropertiesFile;

public class UserJsons {

    private static final String email = PropertiesFile.readPropertiesFile().getProperty("email_default");
    private static final String password = PropertiesFile.readPropertiesFile().getProperty("password_default");

    public static User generateUser(){
        User user = new User();
        user.setNome("Teste Automation Teste");
        user.setEmail(email);
        user.setPassword(password);
        user.setAdministrador("true");
        return user;
    }
}
