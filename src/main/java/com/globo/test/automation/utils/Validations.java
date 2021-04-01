package com.globo.test.automation.utils;

import com.ibm.icu.impl.Assert;
import net.serenitybdd.core.Reportable;
import net.serenitybdd.core.Serenity;

public class Validations {

    public static void validateIfTextContains(String realText, String expectedText){
        if(!realText.contains(expectedText)){
            Assert.fail("Real text => "+realText+" .Expected text => "+expectedText);
        }
    }
    public static void compareObjects(Object real, Object expected){
        if(!real.equals(expected)){
            Assert.fail("Real text => "+real+" .Expected text => "+expected);
        }
    }
}
