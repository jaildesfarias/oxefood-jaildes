package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que essa interface é um repositório do Spring
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    // Você pode adicionar métodos customizados aqui se precisar (ex: buscar por nome, CPF etc.)
}


