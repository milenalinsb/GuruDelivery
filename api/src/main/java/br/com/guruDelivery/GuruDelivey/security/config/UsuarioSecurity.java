package br.com.guruDelivery.GuruDelivey.security.config;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioSecurity implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;

    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;

    public UsuarioSecurity(Usuario usuario) {

        this.id = usuario.getId();
        this.username = usuario.getEmail();
        this.password = usuario.getSenha();

        this.accountNonExpired = usuario.isAtivo();
        this.accountNonLocked = usuario.isAtivo();
        this.credentialsNonExpired = usuario.isAtivo();
        this.enabled = usuario.isAtivo();

        this.authorities = usuario.getPermissoes().stream()
                .map(permissao -> new SimpleGrantedAuthority(permissao.getFuncao().getRole()))
                .collect(Collectors.toList());
    }

    public UsuarioSecurity(Empresa empresa) {

        this.id = empresa.getId();
        this.username = empresa.getEmail();
        this.password = empresa.getSenha();

        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority("ROLE_EMPRESA"));
    }
}
