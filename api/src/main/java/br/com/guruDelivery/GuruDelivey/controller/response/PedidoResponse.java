package br.com.guruDelivery.GuruDelivey.controller.response;

import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.domain.ProdutoPedido;
import br.com.guruDelivery.GuruDelivey.domain.Status;
import br.com.guruDelivery.GuruDelivey.security.controller.response.UsuarioResponse;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Data
public class PedidoResponse {

    private Long id;
    private LocalDateTime dataPedido;
    private EmpresaResponse empresa;
    private UsuarioResponse usuario;
    private Status status;
    private List<ProdutoPedidoResponse> produtosPedido;

}
