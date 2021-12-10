package com.amora.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private   String id  ;
    private String nome;
    private String endereco;
    private String email;
    private String senha;
    private Carrinho carrinho;


    public Cliente(String id, String nome, String endereco, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

}
