
package br.com.ifpe.oxefood.api.cliente;

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

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;

import jakarta.validation.Valid;

@RestController //Faz a classe ser um controller
@RequestMapping("/api/cliente")
@CrossOrigin //Utilizada para o controller receber requisições do React

public class ClienteController {
      @Autowired //Instanciar no cliente service
   private ClienteService clienteService;

   @PostMapping //Especificar que essa função vai receber requisições do tipo Post
   public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {

       Cliente cliente = clienteService.save(request.build());
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
   }

   @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) { //Recebe o id e os dados do cliente

       clienteService.update(id, request.build()); //Objeto preenchido sera enviado para o service
       return ResponseEntity.ok().build();
 }

   @DeleteMapping("/{id}") // passar o id do cliente que eu quero remover
   public ResponseEntity<Void> delete(@PathVariable Long id) { //repassar o id para a função delete

       clienteService.delete(id);
       return ResponseEntity.ok().build();
   }

   }



