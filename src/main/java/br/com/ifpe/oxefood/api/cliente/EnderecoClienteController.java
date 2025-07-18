package br.com.ifpe.oxefood.api.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoClienteService;

@RestController
@RequestMapping("/api/endereco-cliente")
@CrossOrigin(origins = "*") // Permite acesso de qualquer origem (pode ajustar se necessário)
public class EnderecoClienteController {

    @Autowired
    private EnderecoClienteService enderecoClienteService;

    @PostMapping
    public EnderecoCliente salvar(@RequestBody EnderecoCliente enderecoCliente) {
        return enderecoClienteService.save(enderecoCliente);
    }

    @GetMapping
    public List<EnderecoCliente> listarTodos() {
        return enderecoClienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public EnderecoCliente obterPorId(@PathVariable Long id) {
        return enderecoClienteService.obterPorID(id);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<EnderecoCliente> buscarPorCliente(@PathVariable Long idCliente) {
        return enderecoClienteService.buscarPorCliente(idCliente);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody EnderecoCliente enderecoAlterado) {
        enderecoClienteService.update(id, enderecoAlterado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        enderecoClienteService.delete(id);
    }
}
