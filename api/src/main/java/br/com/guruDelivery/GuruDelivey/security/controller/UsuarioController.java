package br.com.guruDelivery.GuruDelivey.security.controller;

import br.com.guruDelivery.GuruDelivey.controller.request.AlterarProdutoRequest;
import br.com.guruDelivery.GuruDelivey.controller.request.CarrinhoRequest;
import br.com.guruDelivery.GuruDelivey.controller.request.EnderecoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.CarrinhoResponse;
import br.com.guruDelivery.GuruDelivey.controller.response.EnderecoResponse;
import br.com.guruDelivery.GuruDelivey.security.controller.request.UsuarioRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoPedidoResponse;
import br.com.guruDelivery.GuruDelivey.security.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.service.*;
import br.com.guruDelivery.GuruDelivey.security.service.IncluirUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService service;

    @Autowired
    private CriarEnderecoService criarEnderecoService;

    @Autowired
    private ListarEnderecosService listarEnderecosService;

    @Autowired
    private AdicionarProdutoAoCarrinhoService adicionarProdutoAoCarrinhoService;

    @Autowired
    private ListarCarrinhoService listarCarrinhoService;

    @Autowired
    private RemoverProdutoCarrinhoService removerProdutoCarrinhoService;

    @Autowired
    private AlterarProdutoCarrinhoService alterarProdutoCarrinhoService;

    @PostMapping
    public UsuarioResponse incluir(@RequestBody UsuarioRequest request) {
        return service.incluir(request);
    }

    @PostMapping("/{id}/enderecos/adicionar")
    @ResponseStatus(CREATED)
    public EnderecoResponse criarEndereco(@PathVariable Long id, @RequestBody EnderecoRequest request) {
        return criarEnderecoService.criar(id, request);
    }

    @GetMapping("/{id}/enderecos")
    public List<EnderecoResponse> listarEnderecos(@PathVariable Long id) {
        return listarEnderecosService.listar(id);
    }

    @PostMapping("/{id}/carrinho/adicionar")
    @ResponseStatus(CREATED)
    public CarrinhoResponse adicionar(@PathVariable Long id, @RequestBody CarrinhoRequest request) {
        return adicionarProdutoAoCarrinhoService.adicionar(id, request);
    }

    /*
    @GetMapping("/{idUsuario}/{idEmpresa}/carrinho")
    public List<ProdutoPedidoResponse> listarProdutos(@PathVariable Long idUsuario, @PathVariable Long idEmpresa) {
        return listarCarrinhoService.listar(idUsuario, idEmpresa);
    }*/

    @DeleteMapping("/{idUsuario}/{idEmpresa}/carrinho/{idProduto}")
    @ResponseStatus(NO_CONTENT)
    public void deletar(@PathVariable Long idUsuario, @PathVariable Long idEmpresa, @PathVariable Long idProduto) {
        removerProdutoCarrinhoService.deletar(idUsuario, idEmpresa, idProduto);
    }

    @PatchMapping("/{idUsuario}/{idEmpresa}/carrinho/{idProduto}/alterar")
    @ResponseStatus(OK)
    public void alterar(@PathVariable Long idUsuario, @PathVariable Long idEmpresa, @PathVariable Long idProduto, @RequestBody AlterarProdutoRequest request) {
        alterarProdutoCarrinhoService.alterar(idUsuario, idEmpresa, idProduto, request);
    }
}
