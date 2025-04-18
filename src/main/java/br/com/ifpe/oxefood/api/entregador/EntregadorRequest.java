package br.com.ifpe.oxefood.api.entregador;

// Importa a entidade Entregador do domínio
import br.com.ifpe.oxefood.modelo.entregador.Entregador;

// Anotações do Lombok para gerar getters, setters, construtores e o builder
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat; // Define o formato da data no JSON
import java.time.LocalDate; // Representa datas sem horário

@Data // Lombok: Gera automaticamente getters e setters
@Builder // Lombok: Habilita o uso do padrão de projeto Builder
@NoArgsConstructor // Lombok: Gera um construtor sem argumentos
@AllArgsConstructor // Lombok: Gera um construtor com todos os argumentos
public class EntregadorRequest {

   // Campos básicos do entregador
   private String nome;
   private String cpf;
   private String rg;
   
   @JsonFormat(pattern = "dd/MM/yyyy") // Define o formato esperado da data no JSON
   private LocalDate dataNascimento;
   private String foneCelular;
   private String foneFixo;
   private Integer qtdEntregasRealizadas;
   private Double valorFrete;
   private String enderecoRua;
   private String enderecoCompleto;
   private String enderecoNumero;
   private String enderecoBairro;
   private String enderecoCidade;
   private String enderecoCep;
   private String enderecoUp;

   private Boolean ativo;

   // Método que converte o DTO (EntregadorRequest) em uma entidade (Entregador)
   public Entregador build() {
       return Entregador.builder()
           .nome(nome)
           .cpf(cpf)
           .rg(rg)
           .dataNascimento(dataNascimento)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .qtdEntregasRealizadas(qtdEntregasRealizadas)
           .valorFrete(valorFrete)
           .enderecoRua(enderecoRua)
           .enderecoCompleto(enderecoCompleto)
           .enderecoNumero(enderecoNumero)
           .enderecoBairro(enderecoBairro)
           .enderecoCidade(enderecoCidade)
           .enderecoCep(enderecoCep)
           .enderecoUp(enderecoUp)
           .ativo(ativo)
           .build();
   }
}
