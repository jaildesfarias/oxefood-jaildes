<<<<<<< HEAD
package br.com.ifpe.oxefood.modelo.Produto;

import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
=======
package br.com.ifpe.oxefood.modelo.produto;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
@Entity // transforma numa classe exisitivel no jpa
@Table(name = "Produto") // especifica que a classe sera convertida em tabela
@SQLRestriction("habilitado = true") // acresenta em todas as consultas uma clausula where: where habilidado = true

@Builder // forma de instanciar objetos da classe
=======
@Entity
@Table(name = "Produto")
@SQLRestriction("habilitado = true")
@Builder
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD

public class Produto extends EntidadeAuditavel {
=======
public class Produto extends EntidadeAuditavel {
 private static final long serialVersionUID = 1L;
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3

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

<<<<<<< HEAD
=======
  // Adicione este atributo:
  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private CategoriaProduto categoria;
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
}
