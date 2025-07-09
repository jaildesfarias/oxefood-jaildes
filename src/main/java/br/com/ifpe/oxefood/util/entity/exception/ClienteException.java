package br.com.ifpe.oxefood.util.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ClienteException extends RuntimeException {

    private static final long serialVersionUID = 1L; 

    public static final String MSG_PREFIXO_CLIENTE = 
        "Só são permitidos clientes com número de celular ou telefone fixo de Pernambuco";

    public ClienteException(String msg) {
        super(String.format(msg));
    }
}
