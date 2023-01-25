package br.com.guruDelivery.GuruDelivey.repository;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
