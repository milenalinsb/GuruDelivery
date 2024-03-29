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
public class EnderecoResponse {

    private Long id;
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;
    private UsuarioResponse usuario;

}
