package com.amora.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoEntity {

    private List<ProdutoEntity> produtos = new ArrayList<>();

    public List<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }
}
