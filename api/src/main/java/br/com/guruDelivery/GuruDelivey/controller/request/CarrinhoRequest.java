package br.com.guruDelivery.GuruDelivey.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CarrinhoRequest {

    @NotBlank
    private Long produto;

    @NotBlank
    private Integer quantidade;

}
