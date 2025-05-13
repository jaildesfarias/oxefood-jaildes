package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

   private Long id;
   private String nome;
   private String cpf;
   private String rg;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   private String foneCelular;
   private String foneFixo;
   private Integer qtdEntregasRealizadas;
   private Double valorFrete;

   private String rua;
   private String complemento;
   private String numero;
   private String bairro;
   private String cidade;
   private String estado;
   private String cep;
   private String uf;
   private Boolean ativo;
   
    public Entregador build() {
       return Entregador.builder()
           .id(id)
           .nome(nome)
           .cpf(cpf)
           .rg(rg)
           .dataNascimento(dataNascimento)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .qtdEntregasRealizadas(qtdEntregasRealizadas)
           .valorFrete(valorFrete)
           .rua(rua)
           .complemento(complemento)
           .numero(numero)
           .bairro(bairro)
           .cidade(cidade)
           .cep(cep)
           .uf(uf)
           .ativo(ativo)
           .build();
   }
}


