package br.com.guruDelivery.GuruDelivey.security.repository;

import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
