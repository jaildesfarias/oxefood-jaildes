package br.com.ifpe.oxefood.api.entregador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;

@CrossOrigin
@RequestMapping("/api/entregador")
@RestController
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {
        Entregador entregador = entregadorService.save(request.build());

        return new ResponseEntity<>(entregador, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Entregador> listarTodos() {
        return entregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregador> obterPorID(@PathVariable Long id) {
        Entregador entregador = entregadorService.obterPorID(id);
        if (entregador != null) {
            return ResponseEntity.ok(entregador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {
        entregadorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entregadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
