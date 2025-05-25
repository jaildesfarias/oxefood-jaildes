package br.com.ifpe.oxefood.modelo.categoriaProduto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

  List<CategoriaProduto> findByNome(String codigo);// Busca todos os entregadores com o nome exato informado

    Optional<CategoriaProduto> findByCpf(String titulo); 

}