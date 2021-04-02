package com.globo.test.automation.steps;

import com.globo.test.automation.page.CommonPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import org.fluentlenium.core.annotation.Page;

public class CommonSteps {

    @Page
    CommonPage commonPage;
    
    @Dado("que clicado no menu de vestidos")
    public void clicadoNoMenuDeVestidos(){
        commonPage.clickOnWomenMenu();
    }

    @Dado("que clicado no menu {string}")
    public void clicadoNoMenu(String menu){
        commonPage.clickOnMenu(menu);
    }

    @Quando("clicar para fazer o checkout na tela principal")
    public void realizarClicarParaFazerOCheckout() {
        commonPage.checkoutMainScreen();
    }
}
