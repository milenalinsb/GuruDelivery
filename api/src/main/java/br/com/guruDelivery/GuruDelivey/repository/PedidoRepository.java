package br.com.guruDelivery.GuruDelivey.repository;

import br.com.guruDelivery.GuruDelivey.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}