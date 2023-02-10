package br.com.guruDelivery.GuruDelivey.service;

import br.com.guruDelivery.GuruDelivey.controller.request.AlterarStatusPedidoRequest;
import br.com.guruDelivery.GuruDelivey.controller.response.PedidoResponse;
import br.com.guruDelivery.GuruDelivey.domain.Carrinho;
import br.com.guruDelivery.GuruDelivey.domain.Pedido;
import br.com.guruDelivery.GuruDelivey.domain.ProdutoPedido;
import br.com.guruDelivery.GuruDelivey.domain.Status;
import br.com.guruDelivery.GuruDelivey.mapper.PedidoMapper;
import br.com.guruDelivery.GuruDelivey.repository.CarrinhoRepository;
import br.com.guruDelivery.GuruDelivey.repository.EmpresaRepository;
import br.com.guruDelivery.GuruDelivey.repository.EnderecoRepository;
import br.com.guruDelivery.GuruDelivey.repository.PedidoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Getter @Setter
public class PedidoService {

    private final CarrinhoRepository carrinhoRepository;
    private final EnderecoRepository enderecoRepository;
    private final EmpresaRepository empresaRepository;
    private final PedidoRepository pedidoRepository;

    public PedidoResponse realizarPedido(Long enderecoId, Long empresaId){
        var endereco = enderecoRepository.findById(enderecoId).orElseThrow(()-> new EntityNotFoundException("Endereco não encontrado com o id: "+ enderecoId));
        var empresa = empresaRepository.findById(empresaId).orElseThrow(()-> new EntityNotFoundException("Empresa não encontrada com id: "+empresaId));
        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setEndereco(endereco);
        pedido.setEmpresa(empresa);
        pedido.setStatus(Status.EM_PRODUCAO);
        List<Carrinho> carrinhoList = carrinhoRepository.findAllByUsuarioIdAndEmpresaId(endereco.getUsuario().getId(), empresaId);
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

    public List<PedidoResponse> listarPedidosByUsuario(Long userId){
        var pedidoList = pedidoRepository.findAllByEnderecoUsuarioId(userId);
        return pedidoList.stream().map(PedidoMapper::toResponse).collect(Collectors.toList());
    }

    public List<PedidoResponse> listarPedidosByEmpresa(Long empresaId){
        var pedidoList = pedidoRepository.findAllByEmpresaId(empresaId);
        return pedidoList.stream().map(PedidoMapper::toResponse).collect(Collectors.toList());
    }

    public PedidoResponse detalharPedido(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(()->new EntityNotFoundException("Pedido não encontrado"));
        return PedidoMapper.toResponse(pedido);
    }

    public void alterarStatus(Long pedidoId, AlterarStatusPedidoRequest request) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(()->new EntityNotFoundException("Pedido não encontrado"));
        Status status = Status.valueOf(request.getStatus());
        pedido.setStatus(status);
    }
}
