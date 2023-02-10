package br.com.guruDelivery.GuruDelivey.security.controller;

import br.com.guruDelivery.GuruDelivey.controller.request.ProdutoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.security.controller.request.UsuarioRequest;
import br.com.guruDelivery.GuruDelivey.security.service.IncluirProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private IncluirProdutoService service;

    @PostMapping
    public ProdutoResponse incluir(@RequestBody ProdutoRequest request) {
        return service.incluir(request);
    }

}
