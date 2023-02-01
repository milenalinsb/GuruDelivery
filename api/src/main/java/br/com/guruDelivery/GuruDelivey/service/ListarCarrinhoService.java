package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoPedidoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Carrinho;
import br.com.guruDelivery.GuruDelivey.domain.ProdutoPedido;
import br.com.guruDelivery.GuruDelivey.mapper.ProdutoPedidoMapper;
import br.com.guruDelivery.GuruDelivey.repository.CarrinhoRepository;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import br.com.guruDelivery.GuruDelivey.repository.ProdutoRepository;
import br.com.guruDelivery.GuruDelivey.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarCarrinhoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;


    //FIXME Creio que aqui é só retornar o tipo do carrinho mesmo, não entendi a conversão pra o produtopedido

    public List<ProdutoPedidoResponse> listar(Long idUsuario, Long idEmpresa) {

        List<Carrinho> carrinho = carrinhoRepository.findAllByUsuarioIdAndEmpresaId(idUsuario, idEmpresa);

        List<ProdutoPedido> pedido = carrinho.stream().map(produto -> {
            ProdutoPedido produtoPedido = new ProdutoPedido();
            produtoPedido.setProduto(produto.getProduto());
            produtoPedido.setQuantidade(produto.getQuantidade());
            return produtoPedido;
        }).collect(Collectors.toList());

        List<ProdutoPedidoResponse> retorno = pedido.stream().map(ProdutoPedidoMapper::toResponse).collect(Collectors.toList());

        return retorno;
    }

}
