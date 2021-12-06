package com.amora.cliente.usercase;

import com.amora.cliente.contract.ClienteRepository;
import com.amora.cliente.contract.ProdutoRepository;
import com.amora.cliente.entity.Carrinho;
import com.amora.cliente.entity.Cliente;
import com.amora.cliente.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultarCliente {
    @Autowired
    ClienteRepository repository;

    public Cliente obter(String id){
        Cliente cliente = repository.obter(id);
        return cliente;
    }

    public List<Cliente> listar(){
        return repository.listar();
    }

}
