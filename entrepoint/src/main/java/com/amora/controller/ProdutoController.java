package com.amora.controller;

import com.amora.cliente.entity.Cliente;
import com.amora.cliente.entity.Produto;
import com.amora.cliente.usercase.CadastrarCliente;
import com.amora.cliente.usercase.CadastrarProduto;
import com.amora.cliente.usercase.ConsultarProduto;
import com.amora.converter.ClienteConverter;
import com.amora.request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedidos/produto")
public class ProdutoController {
    @Autowired
    private ConsultarProduto consultarProduto;
    @Autowired
    private CadastrarProduto cadastrarProduto;

    @GetMapping("/{id}")
    public Produto obter(@PathVariable String id){
        return consultarProduto.obter(id);
    }

    @GetMapping()
    public List<Produto> listar(){
        return consultarProduto.listar();
    }
    @PostMapping
    public void  salvar(@RequestBody Produto produto){
        cadastrarProduto.salvar(produto);
    }




}
