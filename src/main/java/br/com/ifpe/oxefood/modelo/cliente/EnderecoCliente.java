package br.com.ifpe.oxefood.modelo.cliente;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EnderecoCliente extends EntidadeAuditavel {

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;
}
