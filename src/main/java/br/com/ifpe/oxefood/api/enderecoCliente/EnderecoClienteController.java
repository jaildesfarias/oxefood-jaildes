package br.com.ifpe.oxefood.api.enderecoCliente;

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

import br.com.ifpe.oxefood.modelo.enderecoCliente.EnderecoCliente;
import br.com.ifpe.oxefood.modelo.enderecoCliente.EnderecoClienteService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/enderecoCliente")
@CrossOrigin
public class EnderecoClienteController {

    @Autowired
    private EnderecoClienteService enderecoClienteService;

    @PostMapping
    public ResponseEntity<EnderecoCliente> save(@RequestBody @Valid EnderecoClienteRequest request) {
        EnderecoCliente enderecoCliente = enderecoClienteService.save(request.build());
        return new ResponseEntity<>(enderecoCliente, HttpStatus.CREATED);
    }

    @GetMapping
    public List<EnderecoCliente> listarTodos() {
        return enderecoClienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public EnderecoCliente obterPorID(@PathVariable Long id) {
        return enderecoClienteService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody EnderecoClienteRequest request) {
        enderecoClienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoClienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/adicionar/{clienteId}")
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(
        @PathVariable("clienteId") Long clienteId,
        @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente endereco = enderecoClienteService.adicionarEnderecoCliente(clienteId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{enderecoId}")
    public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(
        @PathVariable("enderecoId") Long enderecoId,
        @RequestBody EnderecoClienteRequest request) {

        EnderecoCliente endereco = enderecoClienteService.atualizarEnderecoCliente(enderecoId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

    @DeleteMapping("/remover/{enderecoId}")
    public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {
        enderecoClienteService.removerEnderecoCliente(enderecoId);
        return ResponseEntity.noContent().build();
    }
}
