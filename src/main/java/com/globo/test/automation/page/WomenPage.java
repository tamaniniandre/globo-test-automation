package com.globo.test.automation.page;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.globo.test.automation.utils.JavaScript;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.ws.rs.GET;
import java.util.LinkedList;
import java.util.List;

public class WomenPage extends PageObject {

    private static final String LABEL_PRODUCT = "//a[@class='product-name' and normalize-space()='%s']";
    private static final String BTN_ADD_PRODUCT_TO_CHART = ".//ancestor::div[@class='product-container']//a[contains(@title,'Add to cart')]";
    private static final String LABEL_PRICE_PRODUCT = ".//ancestor::div[@class='product-container']//span[contains(@class,'price')]";
    private static final String BTN_CONTINUE_SHOPPING = "//span[@title='Continue shopping']";
    private static final String LABEL_SUCCESS_ADDED_TO_CART = "Product successfully added to your shopping cart";
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public void addProductToChart(List<String> products) throws InterruptedException {
        LinkedList list = new LinkedList();
        for(String product: products) {
            moveTo(String.format(LABEL_PRODUCT, product)).waitUntilPresent();
        /*necessário mover para o elemento duas vezes por causa do scroll da pagina e depois focar no elemento
            para aparecer o botão de adicionar*/
            JavaScript.mouseOverByJs(moveTo(String.format(LABEL_PRODUCT, product)).getElement());
            Serenity.setSessionVariable(product + "_price").to(
                    findBy(String.format(LABEL_PRODUCT, product)).
                            findBy(LABEL_PRICE_PRODUCT).getText().trim());
            moveTo(String.format(LABEL_PRODUCT, product)).findBy(BTN_ADD_PRODUCT_TO_CHART)
                    .waitUntilPresent().click();
            waitForTextToAppear(LABEL_SUCCESS_ADDED_TO_CART);
            find(BTN_CONTINUE_SHOPPING).click();
            waitForTextToDisappear(LABEL_SUCCESS_ADDED_TO_CART);
            list.add(product);
        }
        Serenity.setSessionVariable("productList").to(list);
    }


}
