package com.globo.test.automation.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.core.pages.PageObject;

public class Hooks extends PageObject {

    @Before("@UiTests")
    public void openWebSite(){
        open();

    }
}
