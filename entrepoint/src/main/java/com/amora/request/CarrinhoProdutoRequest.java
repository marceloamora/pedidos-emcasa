package com.amora.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoProdutoRequest {
    private String idCliente;
    private String idProduto;


}
