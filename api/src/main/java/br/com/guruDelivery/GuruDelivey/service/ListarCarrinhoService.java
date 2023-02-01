package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoPedidoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Carrinho;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.domain.ProdutoPedido;
import br.com.guruDelivery.GuruDelivey.mapper.ProdutoMapper;
import br.com.guruDelivery.GuruDelivey.repository.CarrinhoRepository;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import br.com.guruDelivery.GuruDelivey.repository.ProdutoRepository;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
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
    /*

    public List<ProdutoPedidoResponse> listar(Long idUsuario, Long idEmpresa) {

        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        Empresa empresa = empresaRepository.findById(idEmpresa).get();

        List<Carrinho> carrinho = carrinhoRepository.findAllByUsuarioAndEmpresa(usuario, empresa);

        List<ProdutoPedido> pedido = carrinho.stream().map(produto -> {
            ProdutoPedido produtoPedido = new ProdutoPedido();
            produtoPedido.setId(produto.getProduto().getId());
            produtoPedido.setNome(produto.getProduto().getNome());
            produtoPedido.setFoto(produto.getProduto().getFoto());
            produtoPedido.setPreco(produto.getProduto().getPreco());
            produtoPedido.setQuantidade(produto.getQuantidade());
            produtoPedido.setTotal(produto.getProduto().getPreco() * produto.getQuantidade());
            return produtoPedido;
        }).collect(Collectors.toList());

        List<ProdutoPedidoResponse> retorno = pedido.stream().map(ProdutoMapper::toResponseProdutoPedido).collect(Collectors.toList());

        return retorno;
    }
     */
}
