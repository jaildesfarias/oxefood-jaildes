package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto obterPorID(Long id) {
        return produtoRepository.findById(id).orElse(null); // ou lançar exceção customizada
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {
        Produto produto = produtoRepository.findById(id).get();
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

        produtoRepository.save(produto); // Salva o produto atualizado
    }

    @Transactional
    public void delete(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        produto.setAtivo(false); // Marca o produto como inativo
        produtoRepository.save(produto); // Salva a alteração
    }
}
