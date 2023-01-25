package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.request.UsuarioRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.domain.Usuario;

import javax.persistence.Column;
import java.time.LocalDate;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {

        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setCpf(request.getCpf());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setDataNascimento(request.getDataNascimento());
        usuario.setFotoPerfil(request.getFotoPerfil());

        return usuario;
    }

    public static UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .cpf(usuario.getCpf())
                .email(usuario.getEmail())
                .dataNascimento(usuario.getDataNascimento())
                .fotoPerfil(usuario.getFotoPerfil())
                .build();
    }
}
