package br.com.guruDelivery.GuruDelivey.controller.response;

import br.com.guruDelivery.GuruDelivey.security.controller.response.UsuarioResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class CarrinhoResponse {

    private Long id;

    private ProdutoResponse produto;
    private UsuarioResponse usuario;
    private EmpresaResponse empresa;
    private Integer quantidade;
}
