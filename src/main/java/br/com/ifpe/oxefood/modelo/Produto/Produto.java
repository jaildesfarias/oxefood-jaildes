package br.com.ifpe.oxefood.modelo.Produto;

import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // transforma numa classe exisitivel no jpa
@Table(name = "Produto") // especifica que a classe sera convertida em tabela
@SQLRestriction("habilitado = true") // acresenta em todas as consultas uma clausula where: where habilidado = true

@Builder // forma de instanciar objetos da classe
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produto extends EntidadeAuditavel {

  @Column
  private String codigo;

  @Column
  private String titulo;

  @Column
  private String descricao;

  @Column
  private Double valorUnitario;

  @Column
  private Integer tempoEntregaMinimo;

  @Column
  private Integer tempoEntregaMaximo;

}
