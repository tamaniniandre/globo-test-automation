package com.globo.test.automation.webservice.services;

import com.globo.test.automation.dto.Product;
import com.globo.test.automation.utils.FakeDatas;
import com.globo.test.automation.utils.PropertiesFile;
import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class ProductService {

    private static final String baseUri = PropertiesFile.readPropertiesFile().getProperty("base_uri");
    private static final String productoUri = PropertiesFile.readPropertiesFile().getProperty("produtos_uri");
    private static ObjectMapper mapper = new ObjectMapper();

    public static Product postNewProductWithSuccess(Map<String, String> mapProduct, String successMessage){
        Product product = convertMapKeyToProduct(mapProduct);
          String idNewProduct =
                  SerenityRest
                    .given()
                    .contentType(ContentType.JSON)
                    .baseUri(baseUri)
                    .body(product)
                    .post(productoUri)
                    .then()
                    .assertThat()
                        .statusCode(201)
                        .body("message",is(successMessage))
                        .extract()
                        .path("_id");

          product.set_id(idNewProduct);
          Serenity.setSessionVariable("idNewProduct").to(idNewProduct);
          return product;
    }

    public static Product putProductWithSuccess(Map<String, String> mapProduct, String successMessage, int statusCode){
        Product product = convertMapKeyToProduct(mapProduct);
                SerenityRest
                        .given()
                        .contentType(ContentType.JSON)
                        .baseUri(baseUri)
                        .body(product)
                        .put(productoUri +"/"+Serenity.getCurrentSession().get("idNewProduct").toString())
                        .then()
                        .assertThat()
                        .statusCode(statusCode)
                        .body("message",is(successMessage));

        return product;
    }

    public static void getProducByIdSession(int statusCodeExpected){
                 Response response =
                         SerenityRest
                        .given()
                        .contentType(ContentType.JSON)
                        .baseUri(baseUri+"/")
                        .get(productoUri +"/"+Serenity.getCurrentSession().get("idNewProduct").toString());

                 response.then().statusCode(statusCodeExpected);
        Serenity.setSessionVariable("product").to(response.as(Product.class));
    }
    public static void getAllProducs(int statusCodeExpected){
        Response response =
                SerenityRest
                        .given()
                        .contentType(ContentType.JSON)
                        .baseUri(baseUri+"/")
                        .get(productoUri +"/");

        response.then().statusCode(statusCodeExpected);
        Product[] products  = mapper.convertValue(response.getBody().path("produtos"), Product[].class);
        Serenity.setSessionVariable("product").to(products);
    }


    public static void getProducByIdSession(int statusCodeExpected, String message){
        SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri+"/")
                .get(productoUri +"/"+Serenity.getCurrentSession().get("idNewProduct").toString())
                .then()
                .statusCode(statusCodeExpected)
                .body("message",is(message));
    }

    public static void deleteProducByIdSession(int statusCodeExpected, String successMessage){
                SerenityRest
                        .given()
                        .contentType(ContentType.JSON)
                        .baseUri(baseUri+"/")
                        .delete(productoUri +"/"+Serenity.getCurrentSession().get("idNewProduct").toString())
                        .then()
                        .statusCode(statusCodeExpected)
                        .body("message",is(successMessage));
    }

    private static Product convertMapKeyToProduct(Map<String,String> mapKey){
        Product product = new Product();
        if(mapKey.get("nome").contains("Randomico")){
            product.setNome(FakeDatas.generateRandomProductDescription());
        }
        else {
            product.setNome(mapKey.get("nome"));
        }
        product.setDescricao(mapKey.get("descricao"));
        product.setPreco(mapKey.get("preco"));
        product.setQuantidade(mapKey.get("quantidade"));
        return product;

    }


}
