package com.globo.test.automation.utils;

import com.globo.test.automation.dto.Product;
import com.ibm.icu.impl.Assert;
import net.serenitybdd.core.Reportable;
import net.serenitybdd.core.Serenity;

import java.util.LinkedList;
import java.util.List;

public class Validations {

    public static void validateIfTextContains(String realText, String expectedText){
        if(!realText.contains(expectedText)){
            Assert.fail("Real text => "+realText+" .Expected text => "+expectedText);
        }
    }
    public static void compareObjects(Object real, Object expected){
        if(!real.equals(expected)){
            Assert.fail("Real text => "+real.toString()+" .Expected text => "+expected.toString());
        }
    }
    public static void validateIfProductListContains(Product[] listReal, List<Product> listExpected) {
        LinkedList<Product> copyListExpected = new LinkedList<>(listExpected);
        for (Product expected : listExpected) {
            for (Product real : listReal) {
                if (expected.get_id().equals(real.get_id())) {
                    copyListExpected.remove(expected);
                    break;
                }
            }
        }
        if(copyListExpected.size()!= 0){
            Assert.fail("Os produtos abaixo não foram encontrados: "+copyListExpected);
        }
    }
}
