package br.com.ifpe.oxefood.api.categoriaProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProdutoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/categoriaProduto")
@CrossOrigin
@Tag(name = "API Categoria Produto", description = "API responsável pelos serviços de categoria de produto no sistema")
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

   
    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {
        CategoriaProduto categoriaProduto = categoriaProdutoService.save(request.build());
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaProduto);
    }
)
    @GetMapping
    public ResponseEntity<List<CategoriaProduto>> listarTodos() {
        List<CategoriaProduto> categorias = categoriaProdutoService.listarTodos();
        return ResponseEntity.ok(categorias);
    }
")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProduto> obterPorID(@PathVariable Long id) {
        CategoriaProduto categoria = categoriaProdutoService.obterPorID(id);
        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable Long id,
                                                   @RequestBody @Valid CategoriaProdutoRequest request) {
        CategoriaProduto categoriaAtualizada = categoriaProdutoService.update(id, request.build());
        return ResponseEntity.ok(categoriaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
