package br.com.guruDelivery.GuruDelivey.domain;

import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalDateTime dataPedido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Enumerated(STRING)
    private Status status;

    @ManyToMany
    @JoinTable(name = "produto_pedidos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        this.getProdutos().add(produto);
        produto.getPedidos().add(this);
    }
}
