<<<<<<< HEAD

package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente, Long> {
    List<EnderecoCliente> findByClienteId(Long clienteId);
=======
package br.com.ifpe.oxefood.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente, Long> {
  
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
}