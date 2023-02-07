package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.mapper.EmpresaMapper;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaResponse buscar(Long empresaId) {
        Empresa empresa = empresaRepository.findById(empresaId).get();
        return EmpresaMapper.toResponse(empresa);
    }
}
