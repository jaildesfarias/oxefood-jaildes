package br.com.ifpe.oxefood.modelo.venda;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.api.cliente.venda.VendaRequest;
import jakarta.transaction.Transactional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Transactional
    public Venda incluir(VendaRequest request) {
        Venda venda = new Venda();
        venda.setCliente(request.getCliente());
        venda.setProduto(request.getProduto());
        venda.setStatusVenda(request.getStatusVenda());
        venda.setDataVenda(request.getDataVenda());
        venda.setValorTotal(request.getValorTotal());
        venda.setObservacao(request.getObservacao());
        venda.setRetiradaEmLoja(request.getRetiradaEmLoja());
        venda.setHabilitado(true);

        return repository.save(venda);
    }

    public List<Venda> listarTodos() {
        return repository.findAll();
    }

    public Venda obterPorID(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new VendaNaoEncontradaException("Venda não encontrada com id: " + id));
    }

    @Transactional
    public void update(Long id, Venda vendaAlterado) {
        Venda venda = repository.findById(id)
                .orElseThrow(() -> new VendaNaoEncontradaException("Venda não encontrada para atualização"));

        venda.setCliente(vendaAlterado.getCliente());
        venda.setProduto(vendaAlterado.getProduto());
        venda.setStatusVenda(vendaAlterado.getStatusVenda());
        venda.setDataVenda(vendaAlterado.getDataVenda());
        venda.setValorTotal(vendaAlterado.getValorTotal());
        venda.setObservacao(vendaAlterado.getObservacao());
        venda.setRetiradaEmLoja(vendaAlterado.getRetiradaEmLoja());

        repository.save(venda);
    }

    @Transactional
    public void delete(Long id) {
        Venda venda = repository.findById(id)
                .orElseThrow(() -> new VendaNaoEncontradaException("Venda não encontrada para remoção"));

        venda.setHabilitado(false); 
        repository.save(venda);
    }
}
