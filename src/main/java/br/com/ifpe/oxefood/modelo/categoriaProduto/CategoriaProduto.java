package br.com.ifpe.oxefood.modelo.categoriaProduto;

<<<<<<< HEAD
import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
=======
import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD


@Entity
@Table(name = "CategoriaProduto")
@SQLRestriction("habilitado = true") // acrescenta em todas as consultas uma clausula where: habilitado = true
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProduto extends EntidadeAuditavel {

   @Column
   private String descricao;

}
=======
@Entity
@Table(name = "CategoriaProduto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaProduto extends EntidadeNegocio {

    private static final long serialVersionUID = 1L;

    private String nome;

    private String descricao;
}
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
