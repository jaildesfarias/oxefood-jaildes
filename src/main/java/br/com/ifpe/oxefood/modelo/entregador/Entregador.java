package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Dados pessoais
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;

    // Contato
    private String foneCelular;
    private String foneFixo;

    // Dados operacionais
    private Integer qtdEntregasRealizadas;
    private Double valorFrete;
    private Boolean ativo;

    // Endereço (corrigido para seguir o padrão camelCase)
    private String rua;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
}

    }
