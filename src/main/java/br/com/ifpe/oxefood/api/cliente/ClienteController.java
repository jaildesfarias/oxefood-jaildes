package br.com.ifpe.oxefood.api.cliente;

import br.com.ifpe.oxefood.modelo.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco-cliente")
@CrossOrigin(origins = "*")
public class EnderecoClienteController {

    @Autowired
    private EnderecoClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoCliente save(@RequestBody EnderecoClienteRequest request) {
        return service.save(request);
    }

    @GetMapping
    public List<EnderecoCliente> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public EnderecoCliente buscarPorId(@PathVariable Long id) {
        return service.obterPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
