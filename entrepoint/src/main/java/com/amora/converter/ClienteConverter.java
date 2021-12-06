package com.amora.converter;

import com.amora.cliente.entity.Carrinho;
import com.amora.cliente.entity.Cliente;
import com.amora.cliente.entity.Produto;
import com.amora.request.ClienteRequest;
import com.amora.request.ProdutoRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConverter {


    public  Cliente converterTo(ClienteRequest request){
      Cliente cliente = new Cliente();
      cliente.setId(request.getId());
      cliente.setNome(request.getNome());
      cliente.setEndereco(request.getEndereco());
      cliente.setEmail(request.getEmail());
      cliente.setSenha(request.getSenha());
      cliente.setCarrinho(new Carrinho());

      return cliente;
   }




}
