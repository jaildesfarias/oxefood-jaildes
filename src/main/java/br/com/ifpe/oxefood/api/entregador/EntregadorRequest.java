package br.com.ifpe.oxefood.api.entregador;


import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EntregadorRequest {

   private String nome;

   private String cpf;

   private String  rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   
   private String foneCelular;

   private String foneFixo;

   public Entregador build() {

       return Entregador.builder()
           .nome(nome)
           .cpf(cpf)
           .rg(rg)
           .dataNascimento(dataNascimento)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .foneCelular(dataNascimento)
           .qtdEntregasRealizadas(qtdEntregasRealizadas)
           .valorFrete(valorFrete)
           .enderecoRua(enderecoRua)
           .enderecoCompleto(enderecoCompleto)
           .enderecoNumero(enderecoNumero)
           .enderecoBairro(enderecoBairro)
           .enderecoCidade(enderecoCidade)
           .enderecoCep(enderecoCep)
           .enderecoUp(enderecoUp)
            .(ativo)
           
           .build();
   }

}

