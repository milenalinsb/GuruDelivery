package br.com.guruDelivery.GuruDelivey.mapper;

import br.com.guruDelivery.GuruDelivey.controller.response.PedidoResponse;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoPedidoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Pedido;
import br.com.guruDelivery.GuruDelivey.security.mapper.UsuarioMapper;
import org.springframework.beans.BeanUtils;

import java.util.stream.Collectors;

public class PedidoMapper {


    public static PedidoResponse toResponse(Pedido entity) {
        var pedidoResponse = new PedidoResponse();
        BeanUtils.copyProperties(entity, pedidoResponse);
        pedidoResponse.setEndereco(EnderecoMapper.toResponse(entity.getEndereco()));
        pedidoResponse.setUsuario(UsuarioMapper.toResponse(entity.getEndereco().getUsuario()));
        pedidoResponse.setEmpresa(EmpresaMapper.toResponse(entity.getEmpresa()));
        var list = entity.getProdutosPedido().stream().map(produtoPedido -> {
            var produtoPedidoResponse = new ProdutoPedidoResponse();
            produtoPedidoResponse.setProduto(ProdutoMapper.toResponse(produtoPedido.getProduto()));
            produtoPedidoResponse.setId(produtoPedido.getId());
            produtoPedidoResponse.setQuantidade(produtoPedido.getQuantidade());
            return produtoPedidoResponse;
        }).collect(Collectors.toList());
        pedidoResponse.setProdutosPedido(list);
        var total = list.stream().map(produto -> {
            var totalProduto = produto.getProduto().getPreco() * produto.getQuantidade();
            return totalProduto;
        }).reduce((float) 0, (subtotal, totalProduto) -> subtotal + totalProduto);
        pedidoResponse.setTotal(total);
        return pedidoResponse;
    }

}
