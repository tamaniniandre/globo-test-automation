package com.globo.test.automation.steps.ws;

import com.globo.test.automation.dto.Product;
import com.globo.test.automation.utils.Validations;
import com.globo.test.automation.webservice.services.ProductService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.core.Serenity.getCurrentSession;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductSteps {

    Product product = new Product();
    LinkedList<Product> products = new LinkedList<>();

    @Dado("que cadastrado um novo produto com sucesso com os valores")
    public void queCadastradoUmNovoProdutoComOsValores(List<Map<String, String>> mapProduto) {
        product = ProductService.postNewProductWithSuccess(mapProduto.get(0), "Cadastro realizado com sucesso");
    }

    @Dado("que cadastrado vários produtos com sucesso com os valores")
    public void queCadastradoVariosProdutoComOsValores(List<Map<String, String>> mapsProdutos) {
        for(Map<String,String> mapProduto : mapsProdutos) {
            product = ProductService.postNewProductWithSuccess(mapProduto, "Cadastro realizado com sucesso");
            products.add(product);
        }
    }

    @Quando("consultar com sucesso o produto inserido")
    @Quando("consultar com sucesso o produto atualizado")
    public void consultarOProdutoComSucesso() {
        ProductService.getProducByIdSession(200);

    }

    @Quando("atualizar os valores do produto para")
    public void consultarOProdutoComSucesso(List<Map<String, String>> mapProduto) {
        product = ProductService.putProductWithSuccess(mapProduto.get(0), "Registro alterado com sucesso", 200);
    }

    @Quando("deletar com sucesso o produto inserido")
    public void deleteOProdutoComSucesso() {
        ProductService.deleteProducByIdSession(200, "Registro excluído com sucesso");

    }

    @Então("o produto não deve ser encontrado na pesquisa")
    public void consultarOProdutoExcluido() {
        ProductService.getProducByIdSession(400, "Produto não encontrado");

    }

    @Então("os dados do produto consultado devem estar corretos")
    @Então("os dados do produto devem estar atualizados")
    public void osDadosDoProdutoConsultadoDevemEstarCorretos() {
        Product realProduct = (Product) getCurrentSession().get("product");
        Validations.compareObjects(realProduct.getNome(), product.getNome());
        Validations.compareObjects(realProduct.getDescricao(), product.getDescricao());
        Validations.compareObjects(realProduct.getQuantidade(), product.getQuantidade());
        Validations.compareObjects(realProduct.getPreco(), product.getPreco());
    }

    @Quando("consultar a lista de todos os produtos")
    public void consultarAListaDeTodosOsProdutosInseridos() {

        ProductService.getAllProducs(200);
    }

    @Então("os produtos inseridos devem estar presentes na lista")
    public void osProdutosInseridosDevemEstarPresentesNaLista() {
        Validations.validateIfProductListContains((Product[]) getCurrentSession().get("product"), products);
    }
}
