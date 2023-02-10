package br.com.guruDelivery.GuruDelivey.controller;

import br.com.guruDelivery.GuruDelivey.controller.request.EmpresaRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.mapper.EmpresaMapper;
import br.com.guruDelivery.GuruDelivey.security.service.IncluirEmpresaService;
import br.com.guruDelivery.GuruDelivey.service.BuscarEmpresaService;
import br.com.guruDelivery.GuruDelivey.service.ListarEmpresasService;
import br.com.guruDelivery.GuruDelivey.service.ListarProdutoEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    @Autowired
    private IncluirEmpresaService incluirEmpresaServiceservice;

    @Autowired
    private BuscarEmpresaService buscarEmpresaService;

    @Autowired
    private ListarEmpresasService listarEmpresasService;

    @Autowired
    private ListarProdutoEmpresaService listarProdutoEmpresaService;

    @PostMapping
    public EmpresaResponse incluir(@RequestBody EmpresaRequest request) {
        return incluirEmpresaServiceservice.incluir(request);
    }

    @GetMapping
    public List<EmpresaResponse> listar() {
        return listarEmpresasService.listar();
    }

    @GetMapping("/{empresaId}/produtos")
    public List<ProdutoResponse> listarProdutos(@PathVariable Long empresaId) {
        return listarProdutoEmpresaService.listar(empresaId);
    }

    @GetMapping("/{empresaId}")
    public EmpresaResponse buscarEmpresa(@PathVariable Long empresaId) {
        return buscarEmpresaService.buscar(empresaId);
    }
}
