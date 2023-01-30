package br.com.guruDelivery.GuruDelivey.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EnderecoRequest {

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String bairro;

    @NotBlank
    private String rua;

    @NotBlank
    private Integer numero;

    private String complemento;

}
