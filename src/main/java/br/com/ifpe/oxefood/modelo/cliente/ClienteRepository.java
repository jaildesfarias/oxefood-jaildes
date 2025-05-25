package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  List<Cliente> findByNome(String nome);// Busca todos os entregadores com o nome exato informado

    Optional<Cliente> findByCpf(String cpf); 

}