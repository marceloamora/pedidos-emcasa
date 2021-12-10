package com.amora.cliente.usercase;

import com.amora.cliente.contract.ClienteRepository;
import com.amora.cliente.entity.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class ConsultarClienteTest {

    @InjectMocks
    private ConsultarCliente consultarCliente;

    @Mock
    private ClienteRepository repository;
    @BeforeEach
    void setUp() {
        Cliente cliente = Cliente.builder().id("1").nome("nome").senha("senha").email("email")
                .endereco("endereco").build();
        BDDMockito.when(repository.obter("1")).thenReturn(cliente);
        BDDMockito.when(repository.listar()).thenReturn(Arrays.asList(cliente));
    }

    @Test
    void obterSucess() {
        Cliente cliente = consultarCliente.obter("1");
        Assertions.assertTrue(cliente.getId().equals("1"));
    }

    @Test
    void listar() {
        List<Cliente> listar = consultarCliente.listar();
        Assertions.assertTrue(listar.size()==1);
    }
}