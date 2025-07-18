package br.com.ifpe.oxefood.api.cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoClienteRequest {

    private Long clienteId;

    private String rua;

    private String numero;

    private String bairro;

    private String cep;

    private String cidade;

    private String estado;

    private String complemento;
}
