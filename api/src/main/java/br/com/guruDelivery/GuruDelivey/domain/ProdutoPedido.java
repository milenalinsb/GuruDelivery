package br.com.guruDelivery.GuruDelivey.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "produto_pedidos")
public class ProdutoPedido {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    private Integer quantidade;
}
