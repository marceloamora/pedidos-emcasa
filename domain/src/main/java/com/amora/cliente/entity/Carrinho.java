package com.amora.cliente.entity;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto>  produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
