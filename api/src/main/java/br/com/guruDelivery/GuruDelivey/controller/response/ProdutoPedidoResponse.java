package br.com.guruDelivery.GuruDelivey.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoPedidoResponse {

    private Long id;
    private String nome;
    private String foto;
    private Float preco;
    private Integer quantidade;
    private Float total;
}
