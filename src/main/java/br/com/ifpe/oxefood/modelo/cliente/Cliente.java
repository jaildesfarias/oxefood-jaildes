package br.com.ifpe.oxefood.modelo.cliente;

import java.time.LocalDate;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel  {

   @Column
   private String nome;

   @Column(name="dt_nasc")
   private LocalDate dataNascimento;

   @Column
   private String cpf;


   @Column
   private String foneCelular;
   
   @Column
   private String foneFixo;

}
