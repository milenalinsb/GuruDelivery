package br.com.guruDelivery.GuruDelivey.repository;

import br.com.guruDelivery.GuruDelivey.domain.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Long> {
}