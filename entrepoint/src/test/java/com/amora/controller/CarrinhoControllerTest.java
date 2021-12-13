package com.amora.controller;

import com.amora.cliente.entity.Produto;
import com.amora.cliente.usercase.AdicionarProdutoCarrinho;
import com.amora.request.CarrinhoProdutoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
class CarrinhoControllerTest {

    @InjectMocks
    private  CarrinhoController carrinhoController;

    @Mock
    private AdicionarProdutoCarrinho addProdutoCarrinho;


    @BeforeEach
    void setUp() {


        BDDMockito.willDoNothing().given(addProdutoCarrinho).add("1","1");


    }
    @Test
    void setAddProdutoCarrinhoSucesso(){
        CarrinhoProdutoRequest build = CarrinhoProdutoRequest.builder().idProduto("1").idCliente("1").build();
        carrinhoController.adicionarProduto(build);
    }

}