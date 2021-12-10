package com.amora.cliente.usercase;

import com.amora.cliente.contract.ProdutoRepository;
import com.amora.cliente.entity.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CadastrarProdutoTest {

    @InjectMocks
    CadastrarProduto cadastrarProduto;

    @Mock
    ProdutoRepository repository;

    @BeforeEach
    void setUp() {
        Produto produto = Produto.builder().id("1")
                .modelo("modelo").sistema("sistema").preco(BigDecimal.ONE)
                .memoria("memoria").marca("marca").descricao("descricao")
                .chips(1).quantidade(10).build();
        BDDMockito.willDoNothing().given(repository).salvar(produto);
    }

    @Test
    void salvarSucessso() {
        Produto produto = Produto.builder().id("1")
                .modelo("modelo").sistema("sistema").preco(BigDecimal.ONE)
                .memoria("memoria").marca("marca").descricao("descricao")
                .chips(1).quantidade(10).build();
        cadastrarProduto.salvar(produto);
    }
}