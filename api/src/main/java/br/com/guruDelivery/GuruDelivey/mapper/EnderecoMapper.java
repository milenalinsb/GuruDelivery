package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.request.EnderecoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.EnderecoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Endereco;
import br.com.guruDelivery.GuruDelivey.security.mapper.UsuarioMapper;

public class EnderecoMapper {

    public static Endereco toEntity(EnderecoRequest request) {

        Endereco entity = new Endereco();

        entity.setCep(request.getCep());
        entity.setCidade(request.getCidade());
        entity.setBairro(request.getBairro());
        entity.setRua(request.getRua());
        entity.setNumero(request.getNumero());
        entity.setComplemento(request.getComplemento());

        return entity;
    }

    public static EnderecoResponse toResponse(Endereco entity) {
        return EnderecoResponse.builder()
                .id(entity.getId())
                .cep(entity.getCep())
                .cidade(entity.getCidade())
                .bairro(entity.getBairro())
                .rua(entity.getRua())
                .numero(entity.getNumero())
                .complemento(entity.getComplemento())
                .usuario(UsuarioMapper.toResponse(entity.getUsuario()))
                .build();
    }
}
