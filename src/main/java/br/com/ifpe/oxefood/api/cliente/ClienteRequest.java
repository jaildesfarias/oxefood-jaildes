package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data // Gera getters, setters, equals, hashCode e toString automaticamente
@Builder // Permite a construção do objeto usando o padrão Builder
@NoArgsConstructor // Cria o construtor sem parâmetros
@AllArgsConstructor // Cria o construtor com todos os parâmetros
@Getter
@Setter
public class ClienteRequest {

    private String nome;
    
    @JsonFormat(pattern = "dd/MM/yyyy") // Formata a data no padrão brasileiro
    private LocalDate dataNascimento;

    private String cpf;

    private String foneCelular;

    private String foneFixo;

    // Converte o ClienteRequest para a entidade Cliente
    public Cliente build() {
        return Cliente.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .build();
    }
}
