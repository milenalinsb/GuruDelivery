package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoPedidoResponse;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Produto;
import br.com.guruDelivery.GuruDelivey.domain.ProdutoPedido;

public class ProdutoMapper {

    public static ProdutoResponse toResponse(Produto entity) {
        return ProdutoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .foto(entity.getFoto())
                .preco(entity.getPreco())
                .descricao(entity.getDescricao())
                .empresa(entity.getEmpresa())
                .build();
    }

    public static ProdutoPedidoResponse toResponseProdutoPedido(ProdutoPedido produto) {
        return ProdutoPedidoResponse.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .foto(produto.getFoto())
                .preco(produto.getPreco())
                .quantidade(produto.getQuantidade())
                .total(produto.getTotal())
                .build();
    }
}
