package br.com.ifpe.oxefood.api.itemPedidoRequest.java;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 

@Getter
@Setter
public class ItemPedidoRequest {
    
     private Long pedidoId;
    private Long produtoId;
    private int quantidade;
    private double valorUnitarioItem;
    private double valorTotalItem;
    private String observacaoItem;

}
