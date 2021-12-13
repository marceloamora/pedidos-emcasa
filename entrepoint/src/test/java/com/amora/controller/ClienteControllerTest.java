package com.amora.controller;

import com.amora.cliente.entity.Cliente;
import com.amora.cliente.usercase.CadastrarCliente;
import com.amora.cliente.usercase.ConsultarCliente;
import com.amora.converter.ClienteConverter;
import com.amora.request.ClienteRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
class ClienteControllerTest {

   @InjectMocks
   private  ClienteController clienteController;

   @Mock
   private ConsultarCliente consultarCliente;

   @Mock
   private CadastrarCliente cadastrarCliente;


    @Mock
    private ClienteConverter clienteConverter;

    @BeforeEach
    void setUp() {
        Cliente clienteMock = Cliente.builder().id("1").nome("joao").email("endereco@endereco.com.br").build();
        BDDMockito.when(consultarCliente.obter("1")).thenReturn(clienteMock);

        BDDMockito.when(consultarCliente.listar()).thenReturn(Arrays.asList(clienteMock));

        BDDMockito.willDoNothing().given(cadastrarCliente).cadastrar(clienteMock);
        ClienteRequest request = new ClienteRequest();
        request.setId("1");
        request.setNome("nome");
        request.setEndereco("endereco");
        request.setEmail("email");
        request.setSenha("senha");
        BDDMockito.when(clienteConverter.converterTo(request)).thenReturn(clienteMock);
    }

    @Test
    @DisplayName("Teste com sucesso para pegar um id")
    void obterComSucesso() {

        Cliente obter = clienteController.obter("1");
        Assertions.assertTrue(obter.getId().equals("1"));
    }

    @Test
    void listarComSucesso() {
        List<Cliente> listar = clienteController.listar();
        Assertions.assertTrue(listar.size()==1);
    }

    @Test
    void saveSucesso() {
        clienteController.save(ArgumentMatchers.any());
    }
}