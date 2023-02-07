package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.request.CarrinhoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.CarrinhoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Carrinho;
import br.com.guruDelivery.GuruDelivey.security.mapper.UsuarioMapper;

public class CarrinhoMapper {
    public static Carrinho toEntity(CarrinhoRequest request) {

        Carrinho entity = new Carrinho();

        entity.setQuantidade(request.getQuantidade());

        return entity;
    }

    public static CarrinhoResponse toResponse(Carrinho entity) {
        return CarrinhoResponse.builder()
                .id(entity.getId())
                .usuario(UsuarioMapper.toResponse(entity.getUsuario()))
                .empresa(EmpresaMapper.toResponse(entity.getEmpresa()))
                .produto(ProdutoMapper.toResponse(entity.getProduto()))
                .quantidade(entity.getQuantidade())
                .build();
    }
}
