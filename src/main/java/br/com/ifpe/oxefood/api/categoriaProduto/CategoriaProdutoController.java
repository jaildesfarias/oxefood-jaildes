package br.com.ifpe.oxefood.api.categoriaProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProdutoService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/categoriaProduto") 
@CrossOrigin
public class CategoriaProdutoController {

    @Autowired 
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping 
    public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {

        CategoriaProduto categoriaProduto = categoriaProdutoService.save(request.build());
        return new ResponseEntity<CategoriaProduto>(categoriaProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoService.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaProduto obterPorID(@PathVariable Long id) {
        return categoriaProdutoService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id,
            @RequestBody CategoriaProdutoRequest request) { // Recebe o id e os dados do cliente

        categoriaProdutoService.update(id, request.build()); // Objeto preenchido sera enviado para o service
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}") // passar o id do cliente que eu quero remover
    public ResponseEntity<Void> delete(@PathVariable Long id) { // repassar o id para a função delete

        categoriaProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }

}