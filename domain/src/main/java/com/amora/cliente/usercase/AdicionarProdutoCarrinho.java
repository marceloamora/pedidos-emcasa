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
public class AdicionarProdutoCarrinho {
    @Autowired
    ClienteRepository repository;
    @Autowired
    ProdutoRepository produtoRepository;



    public void add(String idCliente, String idProduto) {
        Cliente cliente = repository.obter(idCliente);
        if (cliente.getCarrinho() == null) {
            cliente.setCarrinho(new Carrinho());
        }
        List<Produto> listaProduto = cliente.getCarrinho().getProdutos();
        if (listaProduto == null) {
            listaProduto = new ArrayList<>();
        }
        final Produto produto = produtoRepository.obter(idProduto);
        listaProduto.add(produto);
        cliente.getCarrinho().setProdutos(listaProduto);
        repository.save(cliente);
    }
}