package br.com.ifpe.oxefood.modelo.categoriaProduto;

import org.springframework.data.jpa.repository.JpaRepository;

public class CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

List<CategoriaProduto> findByCodigo(String codigo);
    Optional<CategoriaProduto> findByTitulo(String titulo);


}