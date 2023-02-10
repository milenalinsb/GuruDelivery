package br.com.guruDelivery.GuruDelivey.security.config;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import br.com.guruDelivery.GuruDelivey.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarUsuarioSecurityService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Empresa empresa = null;
        var user = usuarioRepository.findByEmail(email);
        if(user.isEmpty()){
            empresa = empresaRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Credenciais inválidas"));
            return new UsuarioSecurity(empresa);
        }
        return user.map(UsuarioSecurity::new)
        .orElseThrow(() -> new UsernameNotFoundException("Credenciais inválidas"));
    }
}
