package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Define essa classe como um serviço gerenciado pelo Spring
public class EntregadorService {

    @Autowired // Injeta automaticamente o repositório
    private EntregadorRepository entregadorRepository;

    // Método para salvar um entregador no banco
    public Entregador save(Entregador entregador) {
        // Aqui você pode adicionar validações ou regras antes de salvar
        entregador.setAtivo(true); // Por exemplo, já marcar como ativo por padrão
        entregador.setQtdEntregasRealizadas(0); // Começa com 0 entregas
        return entregadorRepository.save(entregador);
    }

    // Aqui você pode adicionar métodos como:
    // - buscar por ID
    // - listar todos
    // - atualizar
    // - deletar
}

