package br.com.ifpe.oxefood.modelo.categoriaProduto;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CategoriaProduto")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
 public class CategoriaProduto extends EntidadeAuditavel  {
  
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne
   private CategoriaProduto categoria;

   @Column
   private String codigo;
  
   @Column
   private String titulo;
  
   @Column
   private String descricao;
  
   @Column
   private Double valorUnitario;
  

 }