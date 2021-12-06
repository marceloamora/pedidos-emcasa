package com.amora.converter;

import com.amora.cliente.entity.Produto;
import com.amora.request.ProdutoRequest;

public class ProdutoConverter {

    public Produto converterTo(ProdutoRequest request) {
        Produto produto = new Produto();
        produto.setId(request.getId());
        produto.setMarca(request.getMarca());
        produto.setModelo(request.getModelo());
        produto.setSistema(request.getSistema());
        produto.setChips(request.getChips());
        produto.setPreco(request.getPreco());
        produto.setDescricao(request.getDescricao());
        produto.setMemoria(request.getMemoria());

        return produto;
    }

    public ProdutoRequest converterTo(Produto request) {
        ProdutoRequest produto = new ProdutoRequest();
        produto.setId(request.getId());
        produto.setMarca(request.getMarca());
        produto.setModelo(request.getModelo());
        produto.setSistema(request.getSistema());
        produto.setChips(request.getChips());
        produto.setPreco(request.getPreco());
        produto.setDescricao(request.getDescricao());
        produto.setMemoria(request.getMemoria());

        return produto;
    }
}
