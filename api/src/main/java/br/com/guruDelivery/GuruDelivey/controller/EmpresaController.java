package br.com.guruDelivery.GuruDelivey.controller;

import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.service.ListarEmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private ListarEmpresasService listarEmpresasService;

    @GetMapping
    public List<EmpresaResponse> listar() {
        return listarEmpresasService.todos();
    }
}
