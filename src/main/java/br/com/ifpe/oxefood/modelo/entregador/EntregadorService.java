package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.transaction.Transactional;
=======
import org.springframework.transaction.annotation.Transactional; // Import necessário
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 1c3cc6ed70d483072e68ba87dd7c97c5875b2013

@Service
public class EntregadorService {

   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {

       entregador.setHabilitado(Boolean.TRUE);
       return repository.save(entregador);
       
   }
    
    public List<Entregador> listarTodos() {
  
        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {
<<<<<<< HEAD

        return repository.findById(id).get();
    }

    @Transactional
   public void update(Long id, Entregador entregadorAlterado) {//pego id do cliene que vai sr alterado//

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
	    
      repository.save(entregador);//aparte de alteraçao save
  }
  @Transactional//MEXE NO BANCO
   public void delete(Long id) {

       Entregador entregador = repository.findById(id).get();
       entregador.setHabilitado(Boolean.FALSE);//COLOCA NO TRUE

       repository.save(entregador);
   

=======
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
>>>>>>> 1c3cc6ed70d483072e68ba87dd7c97c5875b2013

}
}