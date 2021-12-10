package com.amora.cliente.usercase;

import com.amora.cliente.contract.ClienteRepository;
import com.amora.cliente.entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class CadastrarClienteTest {

    @InjectMocks
    private CadastrarCliente cadastrarCliente;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        Cliente cliente = Cliente.builder().id("1")
                .email("email").nome("nome").endereco("endereco").senha("senha").build();
        BDDMockito.willDoNothing().given(clienteRepository).save(cliente);
    }

    @Test
    void cadastrarSucesso() {
        Cliente cliente = Cliente.builder().id("1")
                .email("email").nome("nome").endereco("endereco").senha("senha").build();
        cadastrarCliente.cadastrar(cliente);
    }
}