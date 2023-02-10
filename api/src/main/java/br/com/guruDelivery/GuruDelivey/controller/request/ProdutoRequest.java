package br.com.guruDelivery.GuruDelivey.controller.request;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String foto;

    @NotBlank
    private Float preco;

    @NotBlank
    private String descricao;

    @NotBlank
    private Empresa empresa;

}
