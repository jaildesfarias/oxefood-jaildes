
package br.com.ifpe.oxefood.modelo.produto;

import java.time.LocalDate;
import java.util.List;
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


@Entity
@Table(name ="CategoriaProduto")
@SQLRestriction("habilidado = true")

@Builder 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaProduto extends EntidadeAuditavel {
 

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