package com.globo.test.automation.page;

import com.globo.test.automation.utils.Calculations;
import com.globo.test.automation.utils.Validations;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;


import java.math.BigDecimal;
import java.util.LinkedList;

import static com.globo.test.automation.utils.Validations.*;

public class CheckoutPage extends PageObject {

    private static final String TABLE_ROWS_COLUMN_DESCRIPTION = "//table//tbody//tr//td[contains(@class,'description')]";
    private static final String TABLE_ROWS_COLUMN_TOTAL = "//table//tbody//tr//td[contains(@class,'total')]";
    private static final String LABEL_TOTAL_PRICE = "total_price";
    private static final String LABEL_TOTAL_SHIPPING = "total_shipping";

    public void validateProducListAdded(){
        LinkedList listProductsAdded = (LinkedList) Serenity.getCurrentSession().get("productList");
        ListOfWebElementFacades listProductsDescription = findAll(TABLE_ROWS_COLUMN_DESCRIPTION);
        ListOfWebElementFacades listProductsTotalPrice = findAll(TABLE_ROWS_COLUMN_TOTAL);
        for(int i = 0; i < listProductsAdded.size(); i++){
            validateIfTextContains(listProductsDescription.get(i).getText(),listProductsAdded.get(i).toString());
            validateIfTextContains(listProductsTotalPrice.get(i).getText(),Serenity.getCurrentSession().get(listProductsAdded.get(i)+"_price").toString());
        }
    }

    public void validateSummarizeCheckout(){
        LinkedList listProductsAdded = (LinkedList) Serenity.getCurrentSession().get("productList");
        LinkedList listPrices = new LinkedList();
        for(int i = 0; i < listProductsAdded.size(); i++){
            listPrices.add(Serenity.getCurrentSession().get(listProductsAdded.get(i)+"_price").toString().replace("$",""));
        }
        Validations.compareObjects(
                new BigDecimal($(By.id(LABEL_TOTAL_PRICE)).getText().replace("$","")),
                Calculations.calculateTotalValue(listPrices, find(By.id(LABEL_TOTAL_SHIPPING)).getText()));
    }

}
