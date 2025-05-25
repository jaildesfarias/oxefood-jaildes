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


@RestController// Define que esta classe é um controlador REST

@RequestMapping("/api/cliente")// Define a URL base para os endpoints deste controller

@CrossOrigin// Permite requisições de origens diferentes (CORS)
public class ClienteController {

    @Autowired// Injeta automaticamente uma instância de ClienteService
    private ClienteService clienteService;

    @PostMapping// Endpoint para salvar um novo cliente (POST /api/cliente)
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {
        // Converte o ClienteRequest em Cliente e salva usando o service
        Cliente cliente = clienteService.save(request.build());
        // Retorna o cliente salvo com status HTTP 201 (Created)
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }
 
    @PutMapping("/{id}") // O {id} é passado na URL O {id} é passado na URLEndpoint para atualizar um cliente existente (PUT /api/cliente/{id})
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {
        
        clienteService.update(id, request.build());// Atualiza o cliente com os dados fornecidos
  
        return ResponseEntity.ok().build();      // Retorna status HTTP 200 (OK) sem corpo
    }

    @DeleteMapping("/{id}") // Endpoint para deletar um cliente por ID (DELETE /api/cliente/{id})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // Exclui o cliente com o ID fornecido
        clienteService.delete(id); // Retorna status HTTP 200 (OK) sem corpo
        return ResponseEntity.ok().build();
        
    }
    
 //   @DeleteMapping("/{id}")
   // public ResponseEntity<Void> remover(@PathVariable Long id) {
  //      try {
       //     clienteService.remover(id);
         //   return ResponseEntity.noContent().build();
        } //catch (ClienteNaoEncontradaException e) {
            //return ResponseEntity.notFound().build();
     //   }
  //  }
//}

