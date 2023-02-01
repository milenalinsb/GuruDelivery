package br.com.guruDelivery.GuruDelivey.controller.response;

import lombok.*;

@Data
public class ProdutoPedidoResponse {

    private Long id;
    private ProdutoResponse produto;
    private Integer quantidade;
}
