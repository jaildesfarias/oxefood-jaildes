package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Indica que essa classe é um serviço gerenciado pelo Spring
public class ProdutoService {

    @Autowired // Injeta automaticamente o repositório
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {// Salva um novo produto no banco
        return produtoRepository.save(produto);
    }

    // Pode adicionar outros métodos úteis como:
    // - buscar por ID
    // - listar todos
    // - atualizar produto
    // - deletar produto
}

