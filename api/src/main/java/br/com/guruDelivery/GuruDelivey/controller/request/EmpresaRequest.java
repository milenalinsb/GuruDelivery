package br.com.guruDelivery.GuruDelivey.controller.request;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmpresaRequest {
    @NotBlank
    private String nome;

    @NotBlank
    private String cnpj;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String fotoPerfil;

    @NotBlank
    private String telefone;

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
