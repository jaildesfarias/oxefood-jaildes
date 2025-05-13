package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto save(Produto produto) {
        produto.setAtivo(Boolean.TRUE); // Ativo por padrão
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto obterPorID(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado."));
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado."));

        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

        produtoRepository.save(produto);
    }

    @Transactional
    public void delete(Long id) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado."));

        produto.setAtivo(Boolean.FALSE); // Soft delete
        produtoRepository.save(produto);

          
    }
}
