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
<<<<<<< HEAD
   public CategoriaProduto save(CategoriaProduto categoriaproduto) { 

       categoriaproduto.setHabilitado(Boolean.TRUE);
       return repository.save(categoriaproduto);
=======
   public CategoriaProduto save(CategoriaProduto categoriaProduto) { 

       categoriaProduto.setHabilitado(Boolean.TRUE);
       return repository.save(categoriaProduto);
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
       
      
   }
   
   public List<CategoriaProduto> listarTodos() {
  
    return repository.findAll();
}

public CategoriaProduto obterPorID(Long id) {

    return repository.findById(id).get();
}

@Transactional
<<<<<<< HEAD
public void update(Long id, CategoriaProduto categoriaprodutoAlterado) {

   CategoriaProduto categoriaproduto = repository.findById(id).get(); //Consultar no banco o CategoriaProduto
   categoriaproduto.setDescricao(categoriaprodutoAlterado.getDescricao());
 
     
   repository.save(categoriaproduto); //Função para cadastra e alterar objeto
=======
public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {

   CategoriaProduto categoriaProduto = repository.findById(id).get(); //Consultar no banco o CategoriaProduto
   categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());
 
     
   repository.save(categoriaProduto); //Função para cadastra e alterar objeto
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
}

@Transactional //Toda vez que for mexer no banco utilizar o transactional
public void delete(Long id) {

<<<<<<< HEAD
    CategoriaProduto categoriaproduto = repository.findById(id).get();
    categoriaproduto.setHabilitado(Boolean.FALSE);

    repository.save(categoriaproduto); //Na verdade está sendo alterado se realmente fosse deletado em vez de save seria o delete
=======
    CategoriaProduto categoriaProduto = repository.findById(id).get();
    categoriaProduto.setHabilitado(Boolean.FALSE);

    repository.save(categoriaProduto); //Na verdade está sendo alterado se realmente fosse deletado em vez de save seria o delete
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
}


    
}
