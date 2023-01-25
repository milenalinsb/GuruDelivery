package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.mapper.EmpresaMapper;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ListarEmpresasService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaResponse> todos() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.stream().map(EmpresaMapper::toResponse).collect(Collectors.toList());
    }
}
