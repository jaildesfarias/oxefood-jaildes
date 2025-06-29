package br.com.ifpe.oxefood.modelo.produto;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {
 private static final long serialVersionUID = 1L;

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

  // Adicione este atributo:
  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private CategoriaProduto categoria;
}
