package com.amora.cliente.usercase;

import com.amora.cliente.contract.ClienteRepository;
import com.amora.cliente.contract.ProdutoRepository;
import com.amora.cliente.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarCliente {
    @Autowired
    ClienteRepository repository;
    @Autowired
    ProdutoRepository produtoRepository;

    public  void cadastrar(Cliente cliente){
        repository.save(cliente);
    }



}
