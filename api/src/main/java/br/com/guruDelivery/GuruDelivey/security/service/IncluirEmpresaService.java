package br.com.guruDelivery.GuruDelivey.security.service;

import br.com.guruDelivery.GuruDelivey.controller.request.EmpresaRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.EmpresaResponse;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.guruDelivery.GuruDelivey.mapper.EmpresaMapper.toEntity;
import static br.com.guruDelivery.GuruDelivey.mapper.EmpresaMapper.toResponse;
@Service
public class IncluirEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmpresaResponse incluir(EmpresaRequest request) {
        Empresa empresa = toEntity(request);
        empresa.setSenha(getSenhaCriptografada(request.getSenha()));

        empresaRepository.save(empresa);
        return toResponse(empresa);
    }

    private String getSenhaCriptografada(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

}
