package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.request.EmpresaRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;

public class EmpresaMapper {

    public static Empresa toEntity(EmpresaRequest request) {
        Empresa entity = new Empresa();
        entity.setNome(request.getNome());
        entity.setCnpj(request.getCnpj());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setFotoPerfil(request.getFotoPerfil());
        entity.setTelefone(request.getTelefone());
        entity.setCep(request.getCep());
        entity.setCidade(request.getCidade());
        entity.setBairro(request.getBairro());
        entity.setRua(request.getRua());
        entity.setNumero(request.getNumero());
        entity.setComplemento(request.getComplemento());
        return entity;
    }

    public static EmpresaResponse toResponse(Empresa entity) {
        return EmpresaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cnpj(entity.getCnpj())
                .email(entity.getEmail())
                .fotoPerfil(entity.getFotoPerfil())
                .telefone(entity.getTelefone())
                .cep(entity.getCep())
                .cidade(entity.getCidade())
                .bairro(entity.getBairro())
                .rua(entity.getRua())
                .numero(entity.getNumero())
                .complemento(entity.getComplemento())
                .build();
    }
}
