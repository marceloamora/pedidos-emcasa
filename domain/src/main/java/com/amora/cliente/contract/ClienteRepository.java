package com.amora.cliente.contract;

import com.amora.cliente.entity.Cliente;

import java.util.List;

public interface ClienteRepository {
    void save (Cliente cliente);
    Cliente obter(String id);
    List<Cliente> listar();
}
