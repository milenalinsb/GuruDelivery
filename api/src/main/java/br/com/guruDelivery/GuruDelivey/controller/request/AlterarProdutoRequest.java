package br.com.guruDelivery.GuruDelivey.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AlterarProdutoRequest {

    @NotBlank
    private Integer quantidade;

}
