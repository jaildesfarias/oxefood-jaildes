package br.com.ifpe.oxefood.modelo.cupom;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CupomDescontoRepository extends JpaRepository<CupomDesconto, Long> {
   Optional<CupomDesconto> findByCogoDesconto(String cpf); 
}
