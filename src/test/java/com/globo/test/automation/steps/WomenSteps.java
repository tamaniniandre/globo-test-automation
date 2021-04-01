package com.globo.test.automation.steps;

import com.globo.test.automation.page.WomenPage;
import io.cucumber.java.pt.E;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class WomenSteps {

    @Page
    WomenPage womenPage;

    @E("que adicionado a lista de produtos aos carrinho na pagina de mulheres")
    public void queAdicionadoAListaDeProdutosAosCarrinhoNaPaginaDeMulheres(List<String> produtos) throws InterruptedException {
            womenPage.addProductToChart(produtos);
    }
}
