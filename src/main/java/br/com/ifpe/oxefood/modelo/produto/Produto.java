package br.com.ifpe.oxefood.modelo.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que esta classe é uma entidade JPA (vai virar uma tabela no banco)
@Data // Lombok: gera getters, setters, equals, hashCode e toString
@Builder // Lombok: habilita o padrão Builder
@NoArgsConstructor // Lombok: cria construtor vazio
@AllArgsConstructor // Lombok: cria construtor com todos os campos
public class Produto {

    @Id // Indica o campo que é chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente no banco
    private Long id;

    private String codigo;
    private String titulo;
    private String descricao;
    private Double valorUnitario;
    private String tempoEntregaMinimo;
    private String tempoEntregaMaximo;

    // Aqui pode adicionar outros campos como: data de validade, ativo, estoque, etc.
}

