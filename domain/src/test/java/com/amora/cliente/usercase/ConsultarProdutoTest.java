package com.amora.cliente.usercase;

import com.amora.cliente.contract.ProdutoRepository;
import com.amora.cliente.entity.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ConsultarProdutoTest {

    @InjectMocks
    private ConsultarProduto consultarProduto;

    @Mock
    private ProdutoRepository repository;

    @BeforeEach
    void setUp() {
        Produto produto = Produto.builder().id("1")
                .modelo("modelo").sistema("sistema").preco(BigDecimal.ONE)
                .memoria("memoria").marca("marca").descricao("descricao")
                .chips(1).quantidade(10).build();
        BDDMockito.when(repository.obter("1")).thenReturn(produto);
        BDDMockito.when(repository.listar()).thenReturn(Arrays.asList(produto));
    }

    @Test
    void obterSucess() {
        Produto obter = consultarProduto.obter("1");
        Assertions.assertTrue(obter.getId().equals("1"));
    }

    @Test
    void listarSucesss() {
        List<Produto> listar = consultarProduto.listar();
        Assertions.assertTrue(listar.size()==1);
    }
}