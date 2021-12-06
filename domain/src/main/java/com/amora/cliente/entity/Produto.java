package com.amora.cliente.entity;

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

public class Produto {
    public Produto(){}
    public Produto(String id, String marca, String modelo, String descricao, String sistema, String memoria, Integer chips, BigDecimal preco, Integer quantidade) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
        this.sistema = sistema;
        this.memoria = memoria;
        this.chips = chips;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    private String id;
    private String marca;
    private String  modelo;
    private String descricao;
    private String sistema;
    private String memoria;
    private Integer chips;
    private BigDecimal preco;
    private Integer quantidade;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public Integer getChips() {
        return chips;
    }

    public void setChips(Integer chips) {
        this.chips = chips;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
