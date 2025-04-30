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

@Entity // Define que essa classe será uma tabela no banco de dados
@Data // Lombok: Gera automaticamente getters, setters, equals, hashCode e toString
@Builder // Lombok: Habilita o padrão de projeto Builder
@NoArgsConstructor // Lombok: Construtor sem argumentos
@AllArgsConstructor // Lombok: Construtor com todos os argumentos
public class Entregador {

    @Id // Define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID pelo banco
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

    // Endereço
    private String Rua;
    private String Completo;
    private String Numero;
    private String Bairro;
    private String Cidade;
    private String Cep;
    private String Uf;
}

