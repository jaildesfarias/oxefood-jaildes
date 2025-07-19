package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoClienteRequest {

    @NotNull
    private Long idCliente;

    @NotEmpty
    private String rua;

    @NotEmpty
    private String numero;

    @NotEmpty
    private String bairro;

    @NotEmpty
    private String cep;

    @NotEmpty
    private String cidade;

    @NotEmpty
    private String estado;

    private String complemento;
}
