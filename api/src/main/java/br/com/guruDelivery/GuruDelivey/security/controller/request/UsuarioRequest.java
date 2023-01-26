package br.com.guruDelivery.GuruDelivey.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private LocalDate dataNascimento;

    @NotBlank
    private String fotoPerfil;

    @NotBlank
    private boolean ativo;
}
