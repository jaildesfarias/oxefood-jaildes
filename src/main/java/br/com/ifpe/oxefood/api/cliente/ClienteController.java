package br.com.ifpe.oxefood.api.cliente;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoClienteService;
import jakarta.validation.Valid;
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


@CrossOrigin(origins = "http://localhost:3001")//Utilizada para o controller receber requisições do React

@RestController //Faz a classe ser um controller
@RequestMapping("/api/cliente")



public class ClienteController {
      @Autowired //Instanciar no cliente service
   private ClienteService clienteService;

<<<<<<< HEAD
  @Autowired
  private EnderecoClienteService enderecoClienteService;

  // função salvar
  @PostMapping
  public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {

    List<EnderecoCliente> enderecos = null;
    if (request.getIdEnderecos() != null && !request.getIdEnderecos().isEmpty()) {
      enderecos = request.getIdEnderecos().stream()
              .map(enderecoClienteService::obterPorID)
              .collect(Collectors.toList());
    }

    Cliente cliente = request.toEntity(enderecos);
    Cliente clienteSalvo = clienteService.save(cliente);

    return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
  }

  @PostMapping("/{id}/endereco")
  public ResponseEntity<EnderecoCliente> adicionarEndereco(@PathVariable("id") Long idCliente,
                                                           @RequestBody @Valid EnderecoCliente endereco) {
    Cliente cliente = clienteService.obterPorID(idCliente);

    if (cliente == null) {
      return ResponseEntity.notFound().build();
    }

    endereco.setCliente(cliente); // Associa o cliente ao endereço
    EnderecoCliente salvo = enderecoClienteService.save(endereco);
    return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
  }



  @GetMapping
  public List<Cliente> listarTodos() {
    return clienteService.listarTodos();
  }
=======
   @PostMapping //Especificar que essa função vai receber requisições do tipo Post
   public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {

       Cliente cliente = clienteService.save(request.build());
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
   }

   @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3

    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

<<<<<<< HEAD
  @GetMapping("/{id}/enderecos")
  public ResponseEntity<List<EnderecoCliente>> listarEnderecosDoCliente(@PathVariable Long id) {
    List<EnderecoCliente> enderecos = enderecoClienteService.buscarPorClienteId(id);
    return ResponseEntity.ok(enderecos);
  }


  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid ClienteRequest request) {

    List<EnderecoCliente> enderecos = null;
    if (request.getIdEnderecos() != null && !request.getIdEnderecos().isEmpty()) {
      enderecos = request.getIdEnderecos().stream()
              .map(enderecoClienteService::obterPorID)
              .collect(Collectors.toList());
    }

    Cliente cliente = request.toEntity(enderecos);
    clienteService.update(id, cliente);

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {

    clienteService.delete(id);
    return ResponseEntity.ok().build();
  }

}
=======
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



>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
