package br.com.guruDelivery.GuruDelivey.controller.response;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ProdutoResponse {

    private Long id;
    private String nome;
    private String foto;
    private Float preco;
    private String descricao;
    private Empresa empresa;

}
