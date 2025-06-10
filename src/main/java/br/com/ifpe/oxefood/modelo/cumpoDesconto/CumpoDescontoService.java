package br.com.ifpe.oxefood.modelo.cumpoDesconto;
    
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CumpoDescontoService {

  @Autowired
  private CumpoDescontoRepository repository;

  @Transactional // escopo de transação no banco de dados
  public CumpoDesconto save(CumpoDesconto cumpoDesconto) {

    cumpoDesconto.setHabilitado(Boolean.TRUE);
    return repository.save(cumpoDesconto);
  }

  public List<CumpoDesconto> listarTodos() {

    return repository.findAll(); // select * from cliente
  }

  public cumpoDescontoobterPorID(Long id) {

    return repository.findById(id).get(); // select * from cliente where id = ?
  }

  @Transactional
   public void update(Long id, CumpoDesconto cumpoDescontoAlterado) {

      CumpoDesconto cumpoDesconto = repository.findById(id).get();
      CumpoDesconto.setPercentualDesconto(cumpoDescontoAlterado.getPercentualDesconto());
      CumpoDesconto.setValorDesconto(cumpoDescontoAlterado.getValorDesconto());
      CumpoDesconto.setValorMinimoPedidoPermitido(cumpoDescontoAlterado.getValorMinimoPedidoPermitido());
      CumpoDesconto.setQuantidadeMaximaUso(cumpoDescontoAlterado.getQuantidadeMaximaUso());
      CumpoDesconto.setInicioVigencia(cumpoDescontoAlterado.getInicioVigencia());
	     CumpoDesconto.setFimVigencia(cumpoDescontoAlterado.getFimVigencia());

      repository.save(cumpoDesconto);
  }

  @Transactional
  public void delete(Long id) {

    CumpoDesconto cumpoDesconto = repository.findById(id).get();
    cumpoDesconto.setHabilitado(Boolean.FALSE);

    repository.save(cumpoDesconto);
  }
}
