package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoPedidoResponse;
import br.com.guruDelivery.GuruDelivey.domain.ProdutoPedido;

public class ProdutoPedidoMapper {

    public static ProdutoPedidoResponse toResponse(ProdutoPedido produtoPedido) {
        return ProdutoPedidoResponse.builder()
                .id(produtoPedido.getId())
                .produto(ProdutoMapper.toResponse(produtoPedido.getProduto()))
                .quantidade(produtoPedido.getQuantidade())
                .preco(produtoPedido.getQuantidade() * produtoPedido.getProduto().getPreco())
                .build();
    }
}
