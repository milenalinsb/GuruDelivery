package br.com.guruDelivery.GuruDelivey.controller;

import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.service.ListarEmpresasService;
import br.com.guruDelivery.GuruDelivey.service.ListarProdutoEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private ListarEmpresasService listarEmpresasService;

    @Autowired
    private ListarProdutoEmpresaService listarProdutoEmpresaService;

    @GetMapping
    public List<EmpresaResponse> listar() {
        return listarEmpresasService.listar();
    }

    @GetMapping("/{empresaId}/produtos")
    public List<ProdutoResponse> listarProdutos(@PathVariable Long empresaId) {
        return listarProdutoEmpresaService.listar(empresaId);
    }
}
