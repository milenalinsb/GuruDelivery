package br.com.guruDelivery.GuruDelivey.repository;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findAllById(Long empresaId);
    Optional<Empresa> findByEmail(String email);
}
