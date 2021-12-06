package com.amora.cliente.contract;

import com.amora.cliente.entity.Produto;

import java.util.List;

public interface ProdutoRepository {
    Produto obter(String id);
    List<Produto> listar();
    void salvar(Produto produto);
}
