package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository // Marca a interface como um componente de acesso a dados
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    //Pode criar métodos personalizados aqui se quiser, por exemplo:
    // List<Produto> findByTituloContaining(String termo);


    // Método customizado para buscar produtos por título
    List<Produto> findByTituloContaining(String titulo);
    
    // Outros métodos personalizados que você precise, por exemplo:
    List<Produto> findByHabilitado(Boolean habilitado);
}



