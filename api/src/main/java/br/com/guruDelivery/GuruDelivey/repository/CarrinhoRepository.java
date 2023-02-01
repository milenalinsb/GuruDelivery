package br.com.guruDelivery.GuruDelivey.repository;

import br.com.guruDelivery.GuruDelivey.domain.Carrinho;
import br.com.guruDelivery.GuruDelivey.domain.Empresa;
import br.com.guruDelivery.GuruDelivey.domain.Produto;
import br.com.guruDelivery.GuruDelivey.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    List<Carrinho> findAllByUsuarioAndEmpresa(Usuario usuario, Empresa empresa);
    List<Carrinho> findAllByUsuarioIdAndEmpresaId(Long usuarioId, Long empresaId);

    Carrinho findAllByUsuarioAndEmpresaAndProduto(Usuario usuario, Empresa empresa, Produto produto);
}
