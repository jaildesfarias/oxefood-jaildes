package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;
import java.util.Arrays;
<<<<<<< HEAD
import java.util.List;

import org.hibernate.validator.constraints.Length;
=======

>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.acesso.Perfil;
import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
<<<<<<< HEAD
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
=======
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest { // vai converter num objeto que tenha os atributos

<<<<<<< HEAD
  private List<Long> idEnderecos;

  @NotNull(message = "O Nome é de preenchimento obrigatório")
  @NotEmpty(message = "O Nome é de preenchimento obrigatório")
  @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
  private String nome;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dataNascimento;

  @NotBlank(message = "O CPF é de preenchimento obrigatório")
  @CPF
  private String cpf;

  @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
  private String foneCelular;

  private String foneFixo;

  @NotBlank(message = "O e-mail é de preenchimento obrigatório")
  @Email
  private String email;

  @NotBlank(message = "A senha é de preenchimento obrigatório")
  private String password;

  public Usuario buildUsuario() {
    return Usuario.builder()
        .username(email)
        .password(password)
        .roles(Arrays.asList(new Perfil(Perfil.ROLE_CLIENTE)))
        .build();
  }

  public Cliente toEntity(List<EnderecoCliente> enderecos) {
    Cliente cliente = Cliente.builder()
        .usuario(buildUsuario())
        .nome(nome)
        .dataNascimento(dataNascimento)
        .cpf(cpf)
        .foneCelular(foneCelular)
        .foneFixo(foneFixo)
        .build();

    if (enderecos != null && !enderecos.isEmpty()) {
      enderecos.forEach(e -> e.setCliente(cliente));
      cliente.setEnderecos(enderecos);
    }

    return cliente;
  }
=======
    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    private String password;
    

    public Usuario buildUsuario() {
       return Usuario.builder()
           .username(email)
           .password(password)
           .roles(Arrays.asList(new Perfil(Perfil.ROLE_CLIENTE)))
           .build();
   }

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy") // Ele vai esperar a anotação em Dia/Mês/Ano
    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    @CPF
    private String cpf;

    private String foneCelular;

    private String foneFixo;

    public Cliente build() {

        return Cliente.builder()
                .usuario(buildUsuario())
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .build();
    }

>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3
}