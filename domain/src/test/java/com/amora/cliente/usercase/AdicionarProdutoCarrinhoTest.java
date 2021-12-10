package com.amora.cliente.usercase;

import com.amora.cliente.contract.ClienteRepository;
import com.amora.cliente.contract.ProdutoRepository;
import com.amora.cliente.entity.Carrinho;
import com.amora.cliente.entity.Cliente;
import com.amora.cliente.entity.Produto;
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
class AdicionarProdutoCarrinhoTest {

    @InjectMocks
    private AdicionarProdutoCarrinho adicionarProdutoCarrinho;

    @Mock
    private ClienteRepository repository;

    @Mock
    private ProdutoRepository produtoRepository;


    @BeforeEach
    void setUp() {
        Cliente clienteMock = Cliente.builder().id("1").nome("nome").senha("senha").email("email")
                .endereco("endereco")
                .carrinho(new Carrinho())
                .build();

        BDDMockito.when(repository.obter("1")).thenReturn(clienteMock);

     Produto produtoMock = Produto.builder().id("1")
                .modelo("modelo").sistema("sistema").preco(BigDecimal.ONE)
                .memoria("memoria").marca("marca").descricao("descricao")
                .chips(1).quantidade(10).build();

        BDDMockito.when(produtoRepository.obter("1")).thenReturn(produtoMock);
        BDDMockito.willDoNothing().given(repository)
                .save(clienteMock);
    }

    @Test
    void addSucess() {
        adicionarProdutoCarrinho.add("1","1");
    }
}