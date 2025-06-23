package br.com.ifpe.oxefood.modelo.enderecoCliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoClienteService {

    @Autowired
    private EnderecoClienteRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public EnderecoCliente save(EnderecoCliente enderecoCliente) {
        return repository.save(enderecoCliente);
    }

    public List<EnderecoCliente> listarTodos() {
        return repository.findAll();
    }

    public EnderecoCliente obterPorID(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void update(Long id, EnderecoCliente enderecoAtualizado) {
        EnderecoCliente existente = repository.findById(id).orElseThrow();
        existente.setRua(enderecoAtualizado.getRua());
        existente.setNumero(enderecoAtualizado.getNumero());
        existente.setBairro(enderecoAtualizado.getBairro());
        existente.setCep(enderecoAtualizado.getCep());
        existente.setCidade(enderecoAtualizado.getCidade());
        existente.setEstado(enderecoAtualizado.getEstado());
        existente.setComplemento(enderecoAtualizado.getComplemento());
        repository.save(existente);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public EnderecoCliente adicionarEnderecoCliente(Long clienteId, EnderecoCliente endereco) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
        endereco.setCliente(cliente);
        return repository.save(endereco);
    }

    @Transactional
    public EnderecoCliente atualizarEnderecoCliente(Long id, EnderecoCliente novoEndereco) {
        EnderecoCliente existente = repository.findById(id).orElseThrow();
        existente.setRua(novoEndereco.getRua());
        existente.setNumero(novoEndereco.getNumero());
        existente.setBairro(novoEndereco.getBairro());
        existente.setCep(novoEndereco.getCep());
        existente.setCidade(novoEndereco.getCidade());
        existente.setEstado(novoEndereco.getEstado());
        existente.setComplemento(novoEndereco.getComplemento());
        return repository.save(existente);
    }

    @Transactional
    public void removerEnderecoCliente(Long id) {
        repository.deleteById(id);
    }
}
