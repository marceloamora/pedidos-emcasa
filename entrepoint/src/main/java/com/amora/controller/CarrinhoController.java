package com.amora.controller;

import com.amora.cliente.usercase.AdicionarProdutoCarrinho;
import com.amora.request.CarrinhoProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/carrinho")
public class CarrinhoController {

    @Autowired
    private AdicionarProdutoCarrinho addProdutoCarrinho;

    @PostMapping
    public void adicionarProduto(@RequestBody CarrinhoProdutoRequest req){
        addProdutoCarrinho.add(req.getIdCliente(), req.getIdProduto());

    }
}
