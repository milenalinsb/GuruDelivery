package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.request.CarrinhoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.CarrinhoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Carrinho;
import br.com.guruDelivery.GuruDelivey.domain.Produto;
import br.com.guruDelivery.GuruDelivey.mapper.CarrinhoMapper;
import br.com.guruDelivery.GuruDelivey.repository.CarrinhoRepository;
import br.com.guruDelivery.GuruDelivey.repository.ProdutoRepository;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import br.com.guruDelivery.GuruDelivey.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarProdutoAoCarrinhoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public CarrinhoResponse adicionar(Long idUsuario, CarrinhoRequest request) {

        Produto produto = produtoRepository.findById(request.getProduto()).get();

        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        Carrinho carrinho = CarrinhoMapper.toEntity(request);

        if(carrinhoRepository.existsByProdutoAndUsuario(produto, usuario)){
            carrinho = carrinhoRepository.findByProdutoAndUsuario(produto, usuario);
            carrinho.setQuantidade(carrinho.getQuantidade() + request.getQuantidade());
        } else{
            carrinho.setProduto(produto);
            carrinho.setEmpresa(produto.getEmpresa());
            carrinho.setUsuario(usuario);
        }

        carrinhoRepository.save(carrinho);

        return CarrinhoMapper.toResponse(carrinho);
    }
}
