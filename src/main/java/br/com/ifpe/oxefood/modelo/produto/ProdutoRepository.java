package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository // Marca a interface como um componente de acesso a dados
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    List<Produto> findByTituloContaining(String titulo);// Método customizado para buscar produtos por título
    
    List<Produto> findByHabilitado(Boolean habilitado); // Outros métodos personalizados que você precise, por exemplo:
}



