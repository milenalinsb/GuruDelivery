package br.com.guruDelivery.GuruDelivey.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ProdutoPedidoResponse {

    private Long id;
    private ProdutoResponse produto;
    private Integer quantidade;
    private Float preco;
}
