package br.com.ifpe.oxefood.modelo.categoriaProduto;

import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CategoriaProduto")
public class CategoriaProduto extends EntidadeNegocio {

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
