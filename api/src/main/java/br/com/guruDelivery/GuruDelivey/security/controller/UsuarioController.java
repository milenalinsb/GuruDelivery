package br.com.guruDelivery.GuruDelivey.security.controller;

import br.com.guruDelivery.GuruDelivey.controller.request.EnderecoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.EnderecoResponse;
import br.com.guruDelivery.GuruDelivey.security.controller.request.UsuarioRequest;
import br.com.guruDelivery.GuruDelivey.security.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.security.service.IncluirUsuarioService;
import br.com.guruDelivery.GuruDelivey.security.service.ListarEnderecosService;
import br.com.guruDelivery.GuruDelivey.service.CriarEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService service;

    @Autowired
    private CriarEnderecoService criarEnderecoService;

    @Autowired
    private ListarEnderecosService listarEnderecosService;

    @PostMapping
    public UsuarioResponse incluir(@RequestBody UsuarioRequest request) {
        return service.incluir(request);
    }

    @PostMapping("/{id}/enderecos/adicionar")
    @ResponseStatus(CREATED)
    public EnderecoResponse criar(@PathVariable Long id, @RequestBody EnderecoRequest request) {
        return criarEnderecoService.criar(id, request);
    }

    @GetMapping("/{id}/enderecos")
    public List<EnderecoResponse> listarEnderecos(@PathVariable Long id) {
        return listarEnderecosService.listar(id);
    }

}
