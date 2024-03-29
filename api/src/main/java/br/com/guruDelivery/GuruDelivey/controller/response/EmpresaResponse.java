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
public class EmpresaResponse {

    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String fotoPerfil;
    private String telefone;
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;
}
