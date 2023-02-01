package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.response.PedidoResponse;
import br.com.guruDelivery.GuruDelivey.domain.*;
import br.com.guruDelivery.GuruDelivey.mapper.PedidoMapper;
import br.com.guruDelivery.GuruDelivey.repository.CarrinhoRepository;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import br.com.guruDelivery.GuruDelivey.repository.PedidoRepository;
import br.com.guruDelivery.GuruDelivey.repository.ProdutoPedidoRepository;
import br.com.guruDelivery.GuruDelivey.security.repository.UsuarioRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Getter @Setter
public class PedidoService {

    private final CarrinhoRepository carrinhoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final PedidoRepository pedidoRepository;

    public PedidoResponse realizarPedido(Long usuarioId, Long empresaId){
        var usuario = usuarioRepository.findById(usuarioId).orElseThrow(()-> new EntityNotFoundException("Usuario não encontrado com o id: "+ usuarioId));
        var empresa = empresaRepository.findById(empresaId).orElseThrow(()-> new EntityNotFoundException("Empresa não encontrada com id: "+empresaId));
        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setUsuario(usuario);
        pedido.setEmpresa(empresa);
        pedido.setStatus(Status.EM_PRODUCAO);
        List<Carrinho> carrinhoList = carrinhoRepository.findAllByUsuarioIdAndEmpresaId(usuarioId, empresaId);
        if(carrinhoList.isEmpty()){
            throw new EntityNotFoundException("Carrinho não encontrado");
        }
        List<Long> ids = new ArrayList<>();
        carrinhoList.forEach(carrinho -> {
            ids.add(carrinho.getId());
            var produtoPedido = new ProdutoPedido();
            produtoPedido.setPedido(pedido);
            produtoPedido.setProduto(carrinho.getProduto());
            produtoPedido.setQuantidade(carrinho.getQuantidade());
            pedido.adicionarProdutoPedido(produtoPedido);
        });
        pedidoRepository.save(pedido);
        carrinhoRepository.deleteAllByIdInBatch(ids);

        return PedidoMapper.toResponse(pedido);
    }

}
