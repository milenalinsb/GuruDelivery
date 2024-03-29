package br.com.guruDelivery.GuruDelivey.controller;

import br.com.guruDelivery.GuruDelivey.controller.request.EmpresaRequest;
import br.com.guruDelivery.GuruDelivey.controller.request.NovaEmpresaRequest;
import br.com.guruDelivery.GuruDelivey.controller.request.NovoProdutoRequest;
import br.com.guruDelivery.GuruDelivey.controller.request.ProdutoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Produto;
import br.com.guruDelivery.GuruDelivey.security.service.IncluirEmpresaService;
import br.com.guruDelivery.GuruDelivey.service.IncluirProdutoService;
import br.com.guruDelivery.GuruDelivey.service.BuscarEmpresaService;
import br.com.guruDelivery.GuruDelivey.service.FileUploadService;
import br.com.guruDelivery.GuruDelivey.service.ListarEmpresasService;
import br.com.guruDelivery.GuruDelivey.service.ListarProdutoEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    @Autowired
    private IncluirEmpresaService incluirEmpresaService;

    @Autowired
    private BuscarEmpresaService buscarEmpresaService;

    @Autowired
    private ListarEmpresasService listarEmpresasService;

    @Autowired
    private ListarProdutoEmpresaService listarProdutoEmpresaService;

    @Autowired
    private IncluirProdutoService incluirProdutoService;

    private final FileUploadService fileUploadService;

    @PostMapping
    public EmpresaResponse incluir(@ModelAttribute NovaEmpresaRequest novaEmpresaRequest) {
        var filename = fileUploadService.saveFile(novaEmpresaRequest.getFotoPerfil());
        var empresaRequest = new EmpresaRequest();
        BeanUtils.copyProperties(novaEmpresaRequest, empresaRequest);
        empresaRequest.setFotoPerfil(filename);
        return incluirEmpresaService.incluir(empresaRequest);
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

    @PostMapping("/{empresaId}")
    public ProdutoResponse incluir(@PathVariable Long empresaId, @ModelAttribute NovoProdutoRequest novaEmpresaRequest) {
        var filename = fileUploadService.saveFile(novaEmpresaRequest.getFoto());
        var request = new ProdutoRequest();
        BeanUtils.copyProperties(novaEmpresaRequest, request);
        request.setFoto(filename);
        return incluirProdutoService.incluir(empresaId, request);
    }
}
