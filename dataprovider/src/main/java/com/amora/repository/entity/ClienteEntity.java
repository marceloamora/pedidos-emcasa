package com.amora.repository.entity;

import com.amora.cliente.entity.Carrinho;
import com.amora.cliente.entity.Cliente;
import com.amora.cliente.entity.Produto;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class ClienteEntity {
    private ObjectId id  ;
    private String nome;
    private String endereco;
    private String email;
    private String senha;
    private CarrinhoEntity carrinho;

    public ClienteEntity(){}

    public ClienteEntity(Cliente cliente) {
        if(cliente.getId()!=null){
            this.id = new ObjectId(cliente.getId());
        }

        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.setCarrinho(new CarrinhoEntity());
        List<ProdutoEntity> lista = new ArrayList<>();
        for(Produto p : cliente.getCarrinho().getProdutos()){
            ProdutoEntity produto = converterTo(p);
            lista.add(produto);
        }
        this.getCarrinho().setProdutos(lista);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CarrinhoEntity getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoEntity carrinho) {
        this.carrinho = carrinho;
    }

    public ProdutoEntity converterTo(Produto request) {
        ProdutoEntity produto = new ProdutoEntity();
        produto.setId(new ObjectId(request.getId()));
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
