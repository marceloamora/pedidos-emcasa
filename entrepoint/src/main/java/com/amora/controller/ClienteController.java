package com.amora.controller;

import com.amora.cliente.entity.Cliente;
import com.amora.cliente.usercase.CadastrarCliente;
import com.amora.cliente.usercase.ConsultarCliente;
import com.amora.converter.ClienteConverter;
import com.amora.request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedidos/cliente")
public class ClienteController {
    @Autowired
    private CadastrarCliente cadastrarCliente;
    @Autowired
    private ConsultarCliente consultarCliente;

    @Autowired
    private ClienteConverter converter;
    
    @GetMapping("/{id}")
    public Cliente obter(@PathVariable String id){
        return consultarCliente.obter(id);
    }

    @GetMapping()
    public   List<Cliente> listar(){
       return consultarCliente.listar();
    }

    @PostMapping
   public void save(@RequestBody ClienteRequest request){
        Cliente cliente = converter.converterTo(request);
        cadastrarCliente.cadastrar(cliente);
    }


}
