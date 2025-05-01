package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;

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
        return entregadorRepository.findById(id).orElse(null); // ou lançar uma exceção customizada
    }

    @Transactional
    public void update(Long id, Entregador entregadorAlterado) {
 
       Entregador entregador = repository.findById(id).get();
       entregador.setNome(entregadorAlterado.getNome());
       entregador.setCpf(entregadorAlterado.getCpf());
       entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
       entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
       entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
  
  
    

      entregador.setQtdEntregasRealizadas( entregadorAlterado.getQtdEntregasRealizadas());
      entregador.setValorFrete( entregadorAlterado.getValorFrete());
      entregador.setRua( entregadorAlterado.getRua());
      entregador.setComplemento(entregadorAlterado.getComplemento());
      entregador.setNumero(entregadorAlterado.getNumero());

      entregador.setBairro( entregadorAlterado.getBairro());
      entregador.setCidade( entregadorAlterado.getCidade());
      entregador.setCep( entregadorAlterado.getCep());
      entregador.setUf(entregadorAlterado.getUf());
      entregador.setAtivo(entregadorAlterado.getAtivo());
	    
      repository.save(entregador);
  }


    // Possíveis métodos adicionais:
    // - atualizar
    // - deletar
    // - buscar por filtros, etc.
}
