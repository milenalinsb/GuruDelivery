package br.com.guruDelivery.GuruDelivey.controller.request;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.domain.ProdutoPedido;
import br.com.guruDelivery.GuruDelivey.domain.Status;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoRequest {

    private String usuarioId;

}
