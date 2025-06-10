package br.com.ifpe.oxefood.modelo.categoriaProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service //Faz a classe ser um serviço
public class CategoriaProdutoService {

    @Autowired 
    private CategoriaProdutoRepository repository;

   @Transactional
   public CategoriaProduto save(CategoriaProduto categoriaProduto) { 

       categoriaProduto.setHabilitado(Boolean.TRUE);
       return repository.save(categoriaProduto);
       
      
   }
   
   public List<CategoriaProduto> listarTodos() {
  
    return repository.findAll();
}

public CategoriaProduto obterPorID(Long id) {

    return repository.findById(id).get();
}

@Transactional
public void update(Long id, CategoriaProduto categoriaprodutoAlterado) {

   CategoriaProduto categoriaProduto = repository.findById(id).get(); //Consultar no banco o CategoriaProduto
   categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());
 
     
   repository.save(categoriaProduto); //Função para cadastra e alterar objeto
}

@Transactional //Toda vez que for mexer no banco utilizar o transactional
public void delete(Long id) {

    CategoriaProduto categoriaProduto = repository.findById(id).get();
    categoriaProduto.setHabilitado(Boolean.FALSE);

    repository.save(categoriaProduto); //Na verdade está sendo alterado se realmente fosse deletado em vez de save seria o delete
}


    
}
