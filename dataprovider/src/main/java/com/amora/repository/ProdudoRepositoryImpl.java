package com.amora.repository;

import com.amora.cliente.contract.ProdutoRepository;
import com.amora.cliente.entity.Produto;
import com.amora.repository.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProdudoRepositoryImpl implements ProdutoRepository {
    @Autowired
    private ProdutoDao produtoDao;

    @Override
    public Produto obter(String id) {
        ProdutoEntity entity = produtoDao.obter(id);
        Produto produto = new Produto(
                entity.getId().toString(),
                entity.getMarca(),
                entity.getModelo(),
                entity.getDescricao(),
                entity.getSistema(),
                entity.getMemoria(),
                entity.getChips(),
                entity.getPreco(),
                entity.getQuantidade()
        );
        return  produto;
    }

    @Override
    public List<Produto> listar() {
         List<Produto> listaRetorno = new ArrayList<>();
        for(ProdutoEntity entity:produtoDao.listar()){
            Produto produto = new Produto(
                    entity.getId().toString(),
                    entity.getMarca(),
                    entity.getModelo(),
                    entity.getDescricao(),
                    entity.getSistema(),
                    entity.getMemoria(),
                    entity.getChips(),
                    entity.getPreco(),
                    entity.getQuantidade()
            );

            listaRetorno.add(produto);
        }
        return listaRetorno;
    }

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity entity = new ProdutoEntity(produto);
         produtoDao.salvar(entity);
    }
}
