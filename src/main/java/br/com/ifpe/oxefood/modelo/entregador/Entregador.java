package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Entregador")
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String foneCelular;
    private String foneFixo;
    private Integer qtdEntregasRealizadas;
    private Double valorFrete;
    private String rua;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private Boolean ativo;
}
