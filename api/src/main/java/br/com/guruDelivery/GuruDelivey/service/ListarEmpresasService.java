package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.mapper.EmpresaMapper;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarEmpresasService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaResponse> listar() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.stream().map(EmpresaMapper::toResponse).collect(Collectors.toList());
    }
}
