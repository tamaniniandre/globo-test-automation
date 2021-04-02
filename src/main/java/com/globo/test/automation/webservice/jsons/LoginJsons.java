package com.globo.test.automation.webservice.jsons;

import com.globo.test.automation.utils.PropertiesFile;
import com.google.gson.JsonObject;
import net.serenitybdd.core.SerenitySystemProperties;
import net.thucydides.core.ThucydidesSystemProperty;

public class LoginJsons {

    private static final String email = PropertiesFile.readPropertiesFile().getProperty("email_default");
    private static final String password = PropertiesFile.readPropertiesFile().getProperty("password_default");

    public static JsonObject loginUserDefaultJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email",email);
        jsonObject.addProperty("password",password);
        return jsonObject;
    }
}
