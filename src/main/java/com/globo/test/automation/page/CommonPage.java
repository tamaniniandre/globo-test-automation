package com.globo.test.automation.page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPage extends PageObject {

    private static final String MENU_WOMEN = "//div[@id='block_top_menu']//a[@title='Women']";
    private static final String MENU_DRESSES = "//div[@id='block_top_menu']//a[@title='Dresses']";
    private static final String MENU_TSHIRTS = "//div[@id='block_top_menu']//a[@title='T-shirts']";
    private static final String MENU_BY_TITLE_TEXT = "//div[@id='block_top_menu']//a[@title='%s']";
    private static final String MY_CARD_DROPDOWN = "//a[@title='View my shopping cart']";
    private static final String BTN_CHECKOUT = "button_order_cart";

    public void clickOnWomenMenu(){
        waitFor(MENU_WOMEN);
        findBy(MENU_WOMEN).click();
    }
    public void clickOnMenu(String title){
        waitFor(String.format(MENU_BY_TITLE_TEXT,title));
        findBy(String.format(MENU_BY_TITLE_TEXT,title)).click();
    }
    public void checkoutMainScreen(){
        moveTo(MY_CARD_DROPDOWN).waitUntilVisible();
        moveTo(MY_CARD_DROPDOWN).setWindowFocus();
        waitFor($(By.id(BTN_CHECKOUT)).getElement()).waitUntilVisible();
        moveTo(By.id(BTN_CHECKOUT)).click();
    }
}
