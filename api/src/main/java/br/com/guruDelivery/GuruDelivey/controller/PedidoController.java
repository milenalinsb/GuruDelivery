package br.com.guruDelivery.GuruDelivey.controller;

import br.com.guruDelivery.GuruDelivey.controller.request.AlterarProdutoRequest;
import br.com.guruDelivery.GuruDelivey.controller.request.AlterarStatusPedidoRequest;
import br.com.guruDelivery.GuruDelivey.controller.request.PedidoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.PedidoResponse;
import br.com.guruDelivery.GuruDelivey.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class PedidoController {

    final PedidoService pedidoService;

    @PostMapping("/empresas/{empresaId}/pedidos")
    public ResponseEntity<PedidoResponse> criarPedido(@PathVariable Long empresaId, @RequestBody PedidoRequest request){
        var pedidoResponse = pedidoService.realizarPedido(request.getEnderecoId(), empresaId);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(pedidoResponse.getId()).toUri())
                .body(pedidoResponse);

    }

    @GetMapping("/usuarios/{userId}/pedidos")
    public ResponseEntity<?> listarTodosPedidos(@PathVariable Long userId){
        return ResponseEntity.ok(pedidoService.listarPedidosByUsuario(userId));
    }

    @GetMapping("/empresas/{empresaId}/pedidos")
    public ResponseEntity<?> listarPedidosEmpresa(@PathVariable Long empresaId){
        return ResponseEntity.ok(pedidoService.listarPedidosByEmpresa(empresaId));
    }

    @GetMapping("/pedidos/{pedidoId}")
    public PedidoResponse retornarPedido(@PathVariable Long pedidoId){
        return pedidoService.detalharPedido(pedidoId);
    }

    @PatchMapping("pedidos/{pedidoId}/alterar")
    @ResponseStatus(OK)
    public void alterarStatusPedido(@PathVariable Long pedidoId, @RequestBody AlterarStatusPedidoRequest request) {
        pedidoService.alterarStatus(pedidoId, request);
    }
}
