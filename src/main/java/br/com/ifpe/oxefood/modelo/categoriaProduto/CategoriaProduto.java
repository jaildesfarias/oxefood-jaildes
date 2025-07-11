package br.com.ifpe.oxefood.modelo.categoriaProduto;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {
        categoriaProduto.setHabilitado(Boolean.TRUE);
        return repository.save(categoriaProduto);
    }

    public List<CategoriaProduto> listarTodos() {
        return repository.findByHabilitadoTrue();
    }

    public CategoriaProduto obterPorID(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("CategoriaProduto não encontrada para o ID: " + id));
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProdutoAlterada) {
        CategoriaProduto categoriaProduto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("CategoriaProduto não encontrada para o ID: " + id));

        categoriaProduto.setDescricao(categoriaProdutoAlterada.getDescricao());
        // repository.save(categoriaProduto); // opcional
    }

    @Transactional
    public void delete(Long id) {
        CategoriaProduto categoriaProduto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("CategoriaProduto não encontrada para o ID: " + id));

        categoriaProduto.setHabilitado(Boolean.FALSE);
        // repository.save(categoriaProduto); // opcional
    }
}
