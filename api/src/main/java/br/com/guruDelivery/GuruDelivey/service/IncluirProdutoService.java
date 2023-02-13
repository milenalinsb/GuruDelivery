package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.request.ProdutoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.domain.Produto;
import br.com.guruDelivery.GuruDelivey.mapper.ProdutoMapper;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import br.com.guruDelivery.GuruDelivey.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncluirProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public ProdutoResponse incluir(Long empresaId, ProdutoRequest request) {


        Produto produto = ProdutoMapper.toEntity(request);
        Empresa empresa = empresaRepository.findById(empresaId).get();
        produto.setEmpresa(empresa);

        produtoRepository.save(produto);
        return ProdutoMapper.toResponse(produto);
    }
}
