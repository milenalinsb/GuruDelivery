package br.com.guruDelivery.GuruDelivey.security.service;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import br.com.guruDelivery.GuruDelivey.security.config.BuscarUsuarioSecurityService;
import br.com.guruDelivery.GuruDelivey.security.config.UsuarioSecurity;
import br.com.guruDelivery.GuruDelivey.security.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import br.com.guruDelivery.GuruDelivey.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioAutenticadoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final BuscarUsuarioSecurityService buscarUsuarioSecurityService;

    public String getUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UsuarioSecurity) {
            return ((UsuarioSecurity) authentication.getPrincipal()).getUsername();
        }

        return null;
    }

    public Object get() {
        String username = getUsername();
        var user = usuarioRepository.findByEmail(username);
        if(user.isPresent()){
            return user.orElseThrow(() -> new UsernameNotFoundException("Username invalido: "+username));
        }
        return empresaRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username invalido: "+username));
    }

    public UsuarioResponse getResponse() {
        Object entity = get();
        if (entity instanceof Usuario){
            var user = (Usuario) entity;
            var usuarioResponse = new UsuarioResponse();
            usuarioResponse.setId(user.getId());
            usuarioResponse.setNome(user.getNome());
            usuarioResponse.setRole("ROLE_USER");
            usuarioResponse.setEmail(user.getEmail());
            return usuarioResponse;
        }else if(entity instanceof Empresa){
            var empresa = (Empresa) entity;
            var usuarioResponse = new UsuarioResponse();
            usuarioResponse.setId(empresa.getId());
            usuarioResponse.setNome(empresa.getNome());
            usuarioResponse.setRole("ROLE_EMPRESA");
            usuarioResponse.setEmail(empresa.getEmail());
            return usuarioResponse;
        }
        return null;
    }
}
