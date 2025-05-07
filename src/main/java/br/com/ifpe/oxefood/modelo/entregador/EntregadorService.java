package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Import necessário
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    public Entregador save(Entregador entregador) {
        entregador.setAtivo(true);
        entregador.setQtdEntregasRealizadas(0);
        return entregadorRepository.save(entregador);
    }

    public List<Entregador> listarTodos() {
        return entregadorRepository.findAll();
    }

    public Entregador obterPorID(Long id) {
        return entregadorRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Long id, Entregador entregadorAlterado) {

        Entregador entregador = entregadorRepository.findById(id).get();

        entregador.setNome(entregadorAlterado.getNome());
        entregador.setCpf(entregadorAlterado.getCpf());
        entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
        entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());

        entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
        entregador.setValorFrete(entregadorAlterado.getValorFrete());
        entregador.setRua(entregadorAlterado.getRua());
        entregador.setComplemento(entregadorAlterado.getComplemento());
        entregador.setNumero(entregadorAlterado.getNumero());
        entregador.setBairro(entregadorAlterado.getBairro());
        entregador.setCidade(entregadorAlterado.getCidade());
        entregador.setCep(entregadorAlterado.getCep());
        entregador.setUf(entregadorAlterado.getUf());
        entregador.setAtivo(entregadorAlterado.getAtivo());

        entregadorRepository.save(entregador);//save Salva ou alterar um objeto entregador,ele vai dar update entregador set nome = nome
    }

    @Transactional
    public void delete(Long id) {
        Entregador entregador = entregadorRepository.findById(id).get();
        entregador.setAtivo(Boolean.FALSE);
        entregadorRepository.save(entregador);
    }
    
    @GetMapping("/api/entregadores/{id}")
public ResponseEntity<Entregador> getEntregador(@PathVariable Long id) {
    Optional<Entregador> entregador = entregadorRepository.findById(id);
    return entregador.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
}

}
