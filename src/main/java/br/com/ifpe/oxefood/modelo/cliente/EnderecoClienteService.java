package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EnderecoClienteService {

    @Autowired
    private EnderecoClienteRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public EnderecoCliente save(EnderecoClienteRequest request) {
        Cliente cliente = clienteRepository.findById(request.getIdCliente())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        EnderecoCliente endereco = new EnderecoCliente();
        endereco.setCliente(cliente);
        endereco.setRua(request.getRua());
        endereco.setNumero(request.getNumero());
        endereco.setBairro(request.getBairro());
        endereco.setCep(request.getCep());
        endereco.setCidade(request.getCidade());
        endereco.setEstado(request.getEstado());
        endereco.setComplemento(request.getComplemento());

        return repository.save(endereco);
    }

    public List<EnderecoCliente> listarTodos() {
        return repository.findAll();
    }

    public EnderecoCliente obterPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado."));
    }

    @Transactional
    public void excluir(Long id) {
        EnderecoCliente endereco = obterPorId(id);
        repository.delete(endereco);
    }
}
