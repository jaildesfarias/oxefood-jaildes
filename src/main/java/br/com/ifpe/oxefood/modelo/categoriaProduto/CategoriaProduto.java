package br.com.ifpe.oxefood.modelo.categoriaProduto;

import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
