package com.globo.test.automation.steps;

import com.globo.test.automation.page.CheckoutPage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.fluentlenium.core.annotation.Page;

public class CheckoutSteps {

    @Page
    CheckoutPage checkoutPage;

    @Então("Validar se os produtos estão corretamentes adicionados ao carrinho")
    public void validarSeOsProdutosEstãoCorretamentesAdicionadosAoCarrinho() {
        checkoutPage.validateProducListAdded();
    }

    @E("Validar se o valor total é igual a somatória dos itens adicionados")
    public void validarSeOValorTotalÉIgualASomatóriaDosItensAdicionados() {
        checkoutPage.validateSummarizeCheckout();

    }
}
