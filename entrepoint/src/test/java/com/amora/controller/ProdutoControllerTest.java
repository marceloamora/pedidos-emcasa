package com.amora.controller;

import com.amora.cliente.entity.Cliente;
import com.amora.cliente.entity.Produto;
import com.amora.cliente.usercase.CadastrarProduto;
import com.amora.cliente.usercase.ConsultarProduto;
import com.amora.request.ClienteRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ConsultarProduto consultarProduto;
    @Mock
    private CadastrarProduto cadastrarProduto;

    @BeforeEach
    void setUp() {
        Produto produtoMock = Produto.builder().id("1").chips(1).descricao("descricao")
                .marca("marca").memoria("120").preco(BigDecimal.ONE).sistema("sistema")
                .modelo("modelo").quantidade(1).build();
        BDDMockito.when(consultarProduto.obter("1")).thenReturn(produtoMock);

        BDDMockito.when(consultarProduto.listar()).thenReturn(Arrays.asList(produtoMock));
        BDDMockito.willDoNothing().given(cadastrarProduto).salvar(produtoMock);


    }


    @Test
    void obterSucesso() {
        Produto obter = produtoController.obter("1");
        Assertions.assertTrue(obter.getId().equals("1"));
    }

    @Test
    void listar() {
        List<Produto> listar = produtoController.listar();
        Assertions.assertTrue(listar.size()==1);
    }

    @Test
    void salvar() {
        Produto produtoMock = Produto.builder().id("1").chips(1).descricao("descricao")
                .marca("marca").memoria("120").preco(BigDecimal.ONE).sistema("sistema")
                .modelo("modelo").quantidade(1).build();
        produtoController.salvar(produtoMock);
    }
}