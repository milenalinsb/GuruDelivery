package br.com.guruDelivery.GuruDelivey.controller;

import br.com.guruDelivery.GuruDelivey.controller.request.UsuarioRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.service.CriarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CriarUsuarioService criarUsuarioService;

    @PostMapping
    @ResponseStatus(CREATED)
    public UsuarioResponse criar(@RequestBody UsuarioRequest request) {
        return criarUsuarioService.criar(request);
    }
}
