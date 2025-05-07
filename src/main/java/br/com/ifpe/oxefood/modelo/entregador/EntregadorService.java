package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.transaction.Transactional;

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
   


}
}