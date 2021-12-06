package com.amora.repository.entity;

import com.amora.cliente.entity.Produto;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

public class ProdutoEntity {

    private ObjectId id;
    private String marca;
    private String  modelo;
    private String descricao;
    private String sistema;
    private String memoria;
    private Integer chips;
    private BigDecimal preco;
    private Integer quantidade;

    public ProdutoEntity(){};
    public ProdutoEntity(Produto produto) {
        if(produto.getId()!=null){
            this.id = new ObjectId(produto.getId());
        }
        this.marca = produto.getMarca();
        this.modelo = produto.getModelo();
        this.descricao = produto.getDescricao();
        this.sistema = produto.getSistema();
        this.memoria = produto.getMemoria();
        this.chips = produto.getChips();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
