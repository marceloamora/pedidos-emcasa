package com.amora.request;

import com.amora.cliente.entity.Produto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoRequest {
    private List<ProdutoRequest> produtos = new ArrayList<>();

    public List<ProdutoRequest> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoRequest> produtos) {
        this.produtos = produtos;
    }
}
