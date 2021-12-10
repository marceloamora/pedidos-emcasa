package com.amora.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
public class Produto {

    public Produto(String id, String marca, String modelo, String descricao, String sistema, String memoria, Integer chips, BigDecimal preco, Integer quantidade) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
        this.sistema = sistema;
        this.memoria = memoria;
        this.chips = chips;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    private String id;
    private String marca;
    private String  modelo;
    private String descricao;
    private String sistema;
    private String memoria;
    private Integer chips;
    private BigDecimal preco;
    private Integer quantidade;

}
