<<<<<<< HEAD
package br.com.ifpe.oxefood.modelo.Produto;
=======
package br.com.ifpe.oxefood.modelo.produto;
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import br.com.ifpe.oxefood.util.entity.exception.ProdutoException;
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
<<<<<<< HEAD

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {
=======
    @Autowired
    private ProdutoRepository repository;

    @Transactional 
    public Produto save(Produto produto) { 
        if (produto.getValorUnitario() < 10) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
        }
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3

        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

<<<<<<< HEAD
    public List<Produto> listarTodos() {   //faz parte da consulta de todos os produtos cadastrados (produtoController)

        return repository.findAll();
    }

    public Produto obterPorID(Long id) {  //faz parte da consulta por id os produtos cadastrados (produtoController)

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {  // Implementando a Alteração (produtoCntroller.java e produtoService

        Produto produto = repository.findById(id).get();
=======
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto obterPorID(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProdutoException("Produto não encontrado com o id: " + id));
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoException("Produto não encontrado com o id: " + id));
        
        produto.setCategoria(produtoAlterado.getCategoria());
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
<<<<<<< HEAD

        repository.save(produto);
    }

    
    @Transactional      // deletar/remover 
    public void delete(Long id) {

        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);

        repository.save(produto);
    }

=======
        
        repository.save(produto);
    }

    @Transactional
    public void delete(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoException("Produto não encontrado com o id: " + id));
        
        produto.setHabilitado(Boolean.FALSE);
        repository.save(produto);
    }
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
}
