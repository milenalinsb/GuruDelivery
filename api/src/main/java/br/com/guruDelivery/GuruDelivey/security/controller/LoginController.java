package br.com.guruDelivery.GuruDelivey.security.controller;

import br.com.guruDelivery.GuruDelivey.security.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioAutenticadoService service;

    @PostMapping
    public UsuarioResponse login() {
        return service.getResponse();
    }
}
