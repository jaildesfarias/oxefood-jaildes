// Define o pacote onde esta classe está localizada
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

// Define que esta classe é um controlador REST
@RestController

// Define a URL base para os endpoints deste controller
@RequestMapping("/api/cliente")

// Permite requisições de origens diferentes (CORS)
@CrossOrigin
public class ClienteController {

    // Injeta automaticamente uma instância de ClienteService
    @Autowired
    private ClienteService clienteService;

    // Endpoint para salvar um novo cliente (POST /api/cliente)
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {
        // Converte o ClienteRequest em Cliente e salva usando o service
        Cliente cliente = clienteService.save(request.build());
        // Retorna o cliente salvo com status HTTP 201 (Created)
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os clientes (GET /api/cliente)
    @GetMapping
    public List<Cliente> listarTodos() {
        // Retorna a lista de todos os clientes
        return clienteService.listarTodos();
    }

    // Endpoint para obter um cliente por ID (GET /api/cliente/{id})
    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        // Retorna o cliente com o ID informado
        return clienteService.obterPorID(id);
    }

    // Endpoint para atualizar um cliente existente (PUT /api/cliente/{id})
    @PutMapping("/{id}") // O {id} é passado na URL
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {
        // Atualiza o cliente com os dados fornecidos
        clienteService.update(id, request.build());
        // Retorna status HTTP 200 (OK) sem corpo
        return ResponseEntity.ok().build();
    }

    // Endpoint para deletar um cliente por ID (DELETE /api/cliente/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // Exclui o cliente com o ID fornecido
        clienteService.delete(id);
        // Retorna status HTTP 200 (OK) sem corpo
        return ResponseEntity.ok().build();
    }
}
