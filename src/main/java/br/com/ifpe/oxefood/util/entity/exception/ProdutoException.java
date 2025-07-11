package br.com.ifpe.oxefood.util.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ProdutoException extends RuntimeException {   
    private static final long serialVersionUID = 1L;

    public static final String MSG_VALOR_MINIMO_PRODUTO = "Não é permitido inserir produtos com valores inferiores a R$ 20.";
    public static final String MSG_VALOR_MAXIMO_PRODUTO = "Não é permitido inserir produtos com valores superiores a R$ 100.";
    public ProdutoException(String msg) {

        super(String.format(msg));
    }
}