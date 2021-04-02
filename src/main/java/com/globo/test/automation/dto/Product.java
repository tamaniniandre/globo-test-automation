package com.globo.test.automation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    private String nome;
    private String preco;
    private String descricao;
    private String quantidade;
    private String _id;
}
