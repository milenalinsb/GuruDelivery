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
        Carrinho carrinho = CarrinhoMapper.toEntity(request);

        Produto produto = produtoRepository.findById(request.getProduto()).get();
        carrinho.setProduto(produto);
        carrinho.setEmpresa(produto.getEmpresa());

        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        carrinho.setUsuario(usuario);

        carrinhoRepository.save(carrinho);

        return CarrinhoMapper.toResponse(carrinho);
    }
}
