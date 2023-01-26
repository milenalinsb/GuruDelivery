package br.com.guruDelivery.GuruDelivey.security.mapper;

import br.com.guruDelivery.GuruDelivey.security.controller.request.UsuarioRequest;
import br.com.guruDelivery.GuruDelivey.security.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setCpf(request.getCpf());
        entity.setEmail(request.getEmail());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setFotoPerfil(request.getFotoPerfil());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setEmail(entity.getEmail());
        return response;
    }
}
