package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Produto;

public class ProdutoMapper {

    public static ProdutoResponse toResponse(Produto entity) {
        return ProdutoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .foto(entity.getFoto())
                .preco(entity.getPreco())
                .descricao(entity.getDescricao())
                .empresa(EmpresaMapper.toResponse(entity.getEmpresa()))
                .build();
    }

}
