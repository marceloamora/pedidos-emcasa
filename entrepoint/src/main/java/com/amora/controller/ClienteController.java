package com.amora.controller;

import com.amora.cliente.entity.Cliente;
import com.amora.cliente.usercase.CadastrarCliente;
import com.amora.cliente.usercase.ConsultarCliente;
import com.amora.converter.ClienteConverter;
import com.amora.request.ClienteRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedidos/cliente")
@Log4j2
@AllArgsConstructor
public class ClienteController {

    private final CadastrarCliente cadastrarCliente;

    private final ConsultarCliente consultarCliente;

    private final ClienteConverter converter;
    
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
