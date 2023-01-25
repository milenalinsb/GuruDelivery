package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class EmpresaMapper {

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
