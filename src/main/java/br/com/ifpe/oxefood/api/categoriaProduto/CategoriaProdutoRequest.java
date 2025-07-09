package br.com.ifpe.oxefood.api.categoriaProduto;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======

import org.hibernate.validator.constraints.Length;
>>>>>>> b507e37c12a19568d02933b6ec66a3ef91667cc3

import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class CategoriaProdutoRequest {

    @NotNull(message = "O Nome é de preenchimento obrigatório")
   @NotEmpty(message = "O Nome é de preenchimento obrigatório")
   @Length(max = 100, message = "O Nome deverá ter no máximo 100 caracteres")
    private String descricao;

    public CategoriaProduto build() {

        return CategoriaProduto.builder()
                .descricao(descricao)
                .build();

    }
}