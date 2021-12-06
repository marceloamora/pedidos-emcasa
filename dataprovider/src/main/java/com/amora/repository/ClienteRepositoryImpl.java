package com.amora.repository;

import com.amora.cliente.contract.ClienteRepository;
import com.amora.cliente.entity.Carrinho;
import com.amora.cliente.entity.Cliente;
import com.amora.cliente.entity.Produto;
import com.amora.repository.entity.ClienteEntity;
import com.amora.repository.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Autowired
    private ClienteDao clienteDao;
    @Override
    public void save(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity(cliente);
        clienteDao.salvar(entity);
    }

    @Override
    public Cliente obter(String id) {
        ClienteEntity obter = clienteDao.obter(id);
        Cliente cliente = new Cliente(obter.getId().toString(),obter.getNome(),obter.getEndereco(),obter.getEmail(),obter.getSenha());
        Carrinho carrinho = getCarrinho(obter);
        cliente.setCarrinho( carrinho);
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> listaRetorno = new ArrayList<>();
        for(ClienteEntity entity:clienteDao.listar()){
            Cliente cliente = new Cliente(entity.getId().toString(), entity.getNome(), entity.getEndereco(), entity.getEmail(), entity.getSenha());
            Carrinho carrinho = getCarrinho(entity);
            cliente.setCarrinho( carrinho);
            listaRetorno.add(cliente);
        }
        return  listaRetorno;
    }


    private Carrinho getCarrinho(ClienteEntity obter) {
        if(obter.getCarrinho()==null){
            return new Carrinho();
        }
        List<Produto> produtos = new ArrayList<>();
        for(ProdutoEntity produtoEntity:obter.getCarrinho().getProdutos()){
            Produto p = new Produto();
            p.setId(produtoEntity.getId().toString());
            p.setModelo(produtoEntity.getModelo());
            p.setMarca(produtoEntity.getMarca());
            p.setPreco(produtoEntity.getPreco());
            produtos.add(p);
        }
        Carrinho carrinho = new Carrinho();
        carrinho.setProdutos(produtos);
        return carrinho;
    }


}
