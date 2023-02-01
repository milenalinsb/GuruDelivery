package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.domain.Carrinho;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.domain.Produto;
import br.com.guruDelivery.GuruDelivey.repository.CarrinhoRepository;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import br.com.guruDelivery.GuruDelivey.repository.ProdutoRepository;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import br.com.guruDelivery.GuruDelivey.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverProdutoCarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public void deletar(Long idUsuario, Long idEmpresa, Long idProduto) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        Empresa empresa = empresaRepository.findById(idEmpresa).get();

        Produto produto = produtoRepository.findById(idProduto).get();

        Carrinho carrinho = carrinhoRepository.findAllByUsuarioAndEmpresaAndProduto(usuario, empresa, produto);

        carrinhoRepository.delete(carrinho);
    }
}
