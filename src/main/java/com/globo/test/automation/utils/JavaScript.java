package com.globo.test.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class JavaScript {

    private static final String jsMouseOver = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";

    public static void mouseOverByJs(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(jsMouseOver,element);


    }
}
