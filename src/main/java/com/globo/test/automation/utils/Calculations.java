package com.globo.test.automation.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Calculations {

    public static BigDecimal calculateTotalValue(List<String> listPrices, String shipping){
        BigDecimal sum = new BigDecimal(0);
        for(String price: listPrices){
            BigDecimal newNumber = new BigDecimal(price.replace("$","")).setScale(2);
            sum = sum.add(newNumber);

        }
        return sum.add(new BigDecimal(shipping.replace("$","")));
    }
}
