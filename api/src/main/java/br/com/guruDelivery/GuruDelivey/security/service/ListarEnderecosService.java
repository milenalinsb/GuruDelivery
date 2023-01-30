package br.com.guruDelivery.GuruDelivey.security.service;

import br.com.guruDelivery.GuruDelivey.controller.response.EnderecoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Endereco;
import br.com.guruDelivery.GuruDelivey.mapper.EnderecoMapper;
import br.com.guruDelivery.GuruDelivey.repository.EnderecoRepository;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import br.com.guruDelivery.GuruDelivey.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarEnderecosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoResponse> listar(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        List<Endereco> enderecos = enderecoRepository.findAllByUsuario(usuario);

        return enderecos.stream().map(EnderecoMapper::toResponse).collect(Collectors.toList());
    }
}
