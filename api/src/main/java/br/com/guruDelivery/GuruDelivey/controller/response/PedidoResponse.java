package br.com.guruDelivery.GuruDelivey.controller.response;

import br.com.guruDelivery.GuruDelivey.domain.Status;
import br.com.guruDelivery.GuruDelivey.security.controller.response.UsuarioResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoResponse {

    private Long id;
    private LocalDateTime dataPedido;
    private EmpresaResponse empresa;
    private UsuarioResponse usuario;
    private EnderecoResponse endereco;
    private Status status;
    private List<ProdutoPedidoResponse> produtosPedido;
    private Float total;

}
