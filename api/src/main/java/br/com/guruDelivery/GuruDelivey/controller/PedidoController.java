package br.com.guruDelivery.GuruDelivey.controller;

import br.com.guruDelivery.GuruDelivey.controller.request.PedidoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.PedidoResponse;
import br.com.guruDelivery.GuruDelivey.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

}
