package com.amora.cliente.usercase;

import com.amora.cliente.contract.ProdutoRepository;
import com.amora.cliente.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarProduto {

    @Autowired
    ProdutoRepository repository;

    public Produto obter(String id){
        return repository.obter(id);
    }
    public List<Produto> listar(){
      return   repository.listar();
    }
}
