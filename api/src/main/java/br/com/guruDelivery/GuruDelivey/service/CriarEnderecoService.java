package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.request.EnderecoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.EnderecoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Endereco;
import br.com.guruDelivery.GuruDelivey.mapper.EnderecoMapper;
import br.com.guruDelivery.GuruDelivey.repository.EnderecoRepository;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import br.com.guruDelivery.GuruDelivey.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriarEnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional
    public EnderecoResponse criar(Long id, EnderecoRequest request) {

        Usuario usuario = usuarioRepository.findById(id).get();

        Endereco endereco = EnderecoMapper.toEntity(request);

        usuario.adicionarEndereco(endereco);

        enderecoRepository.save(endereco);

        return EnderecoMapper.toResponse(endereco);
    }
}
