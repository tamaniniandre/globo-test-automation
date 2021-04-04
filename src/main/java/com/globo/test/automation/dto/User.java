package com.globo.test.automation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String nome;
    private String email;
    private String password;
    private String administrador;

}
