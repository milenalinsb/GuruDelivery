package br.com.guruDelivery.GuruDelivey.security.mapper;

import br.com.guruDelivery.GuruDelivey.controller.request.ProdutoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Produto;
import br.com.guruDelivery.GuruDelivey.mapper.EmpresaMapper;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequest request) {
        Produto entity = new Produto();
        entity.setNome(request.getNome());
        entity.setFoto(request.getFoto());
        entity.setPreco(request.getPreco());
        entity.setDescricao(request.getDescricao());
        entity.setEmpresa(request.getEmpresa());
        return entity;
    }

    public static ProdutoResponse toResponse(Produto entity) {
        ProdutoResponse response = new ProdutoResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setFoto(entity.getFoto());
        response.setPreco(entity.getPreco());
        response.setDescricao(entity.getDescricao());
        response.setEmpresa(EmpresaMapper.toResponse(entity.getEmpresa()));
        return response;
    }

}
