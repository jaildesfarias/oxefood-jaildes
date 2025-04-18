package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok: gera getters, setters, equals, hashCode e toString
@Builder // Lombok: permite construir objetos com .builder()
@NoArgsConstructor // Lombok: construtor sem argumentos
@AllArgsConstructor // Lombok: construtor com todos os argumentos
public class ProdutoRequest {

    private String codigo;
    private String titulo;
    private String descricao; 
    private Double valorUnitario;
    private String tempoEntregaMinimo;
    private String tempoEntregaMaximo;

    // Converte o ProdutoRequest em um Produto (entidade que será salva no banco)
    public Produto build() {
        return Produto.builder()
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaximo(tempoEntregaMaximo)
                .build();
    }
}
