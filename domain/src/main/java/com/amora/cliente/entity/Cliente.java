package com.amora.cliente.entity;

import org.bson.types.ObjectId;

/**
 * Regras de negócio independente da aplicação
 */
public class Cliente {
    private   String id  ;
    private String nome;
    private String endereco;
    private String email;
    private String senha;
    private Carrinho carrinho;
    public Cliente(){

    }

    public Cliente(String id, String nome, String endereco, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
