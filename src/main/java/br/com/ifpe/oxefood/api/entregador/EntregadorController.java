package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.web.bind.annotation.GetMapping;      
import org.springframework.web.bind.annotation.PathVariable; 
>>>>>>> 1c3cc6ed70d483072e68ba87dd7c97c5875b2013
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


<<<<<<< HEAD
=======

>>>>>>> 1c3cc6ed70d483072e68ba87dd7c97c5875b2013
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;


<<<<<<< HEAD

=======
>>>>>>> 1c3cc6ed70d483072e68ba87dd7c97c5875b2013
@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
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
    public Entregador obterPorID(@PathVariable Long id) {
        return entregadorService.obterPorID(id);
    }
    @PutMapping("/{id}")//id do cliente
 public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

       entregadorService.update(id, request.build());//
       return ResponseEntity.ok().build();
 }
<<<<<<< HEAD
  @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       entregadorService.delete(id);
       return ResponseEntity.ok().build();
   }


=======
 @DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    entregadorService.delete(id);
    return ResponseEntity.ok().build();
}

 
>>>>>>> 1c3cc6ed70d483072e68ba87dd7c97c5875b2013

}

