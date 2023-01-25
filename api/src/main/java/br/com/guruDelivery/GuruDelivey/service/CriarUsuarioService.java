package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.request.UsuarioRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.domain.Usuario;
import br.com.guruDelivery.GuruDelivey.mapper.UsuarioMapper;
import br.com.guruDelivery.GuruDelivey.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponse criar(UsuarioRequest request) {
        Usuario usuario = UsuarioMapper.toEntity(request);

        usuarioRepository.save(usuario);

        return UsuarioMapper.toResponse(usuario);
    }
}
