package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Dados pessoais
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;

    // Contato
    private String foneCelular;
    private String foneFixo;

    // Dados operacionais
    private Integer qtdEntregasRealizadas;
    private Double valorFrete;
    

    // Endereço (corrigido para seguir o padrão camelCase)
    private String rua;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
<<<<<<< HEAD
    public void setHabilitado(Boolean true1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHabilitado'");
    }
    
=======
    private Boolean ativo;
>>>>>>> 1c3cc6ed70d483072e68ba87dd7c97c5875b2013
}

    
