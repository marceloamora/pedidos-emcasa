package com.amora.cliente.usercase;

import com.amora.cliente.contract.ProdutoRepository;
import com.amora.cliente.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarProduto {

    @Autowired
    ProdutoRepository repository;

    public void salvar(Produto produto){
         repository.salvar(produto);
    }
}
