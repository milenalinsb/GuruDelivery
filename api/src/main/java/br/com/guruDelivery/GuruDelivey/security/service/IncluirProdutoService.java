package br.com.guruDelivery.GuruDelivey.security.service;

import br.com.guruDelivery.GuruDelivey.controller.request.ProdutoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.ProdutoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Produto;
import br.com.guruDelivery.GuruDelivey.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static br.com.guruDelivery.GuruDelivey.security.mapper.ProdutoMapper.toEntity;
import static br.com.guruDelivery.GuruDelivey.security.mapper.ProdutoMapper.toResponse;

@Service
public class IncluirProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponse incluir(ProdutoRequest request) {
        Produto produto = toEntity(request);

        produtoRepository.save(produto);
        return toResponse(produto);
    }
}
