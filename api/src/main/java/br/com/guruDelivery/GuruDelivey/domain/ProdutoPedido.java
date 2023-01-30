package br.com.guruDelivery.GuruDelivey.domain;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ProdutoPedido {

    private Long id;
    private String nome;
    private String foto;
    private Float preco;
    private Integer quantidade;
    private Float total;
}
