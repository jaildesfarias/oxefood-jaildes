package br.com.ifpe.oxefood.modelo.categoriaProduto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

    List<CategoriaProduto> findByHabilitadoTrue(); // Este método faz o SELECT * FROM categoria_produto WHERE habilitado = true
}
