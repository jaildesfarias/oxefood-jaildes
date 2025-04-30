
package br.com.ifpe.oxefood.api.produto;

import org.springframework.beans.factory.annotation.Autowired; // Import necessário para @Autowired
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import br.com.ifpe.oxefood.modelo.produto.Produto; // Importando a classe Produto
import br.com.ifpe.oxefood.modelo.produto.ProdutoService; // Importando o serviço de Produto

@RestController // Informa ao Spring que essa classe é um controlador REST (responde com JSON)
@RequestMapping("/api/produto") // Define o prefixo da rota para esse controlador. 
// Ou seja, todas as rotas aqui dentro começarão com "/api/produto".
// Exemplo: POST /api/produto vai cair no método save abaixo.
   
@CrossOrigin // Permite que requisições de outros domínios (ex: front-end em localhost:3000) acessem a API
public class ProdutoController {

   @Autowired // Injeta automaticamente uma instância de ProdutoService
   private ProdutoService produtoService;

   @PostMapping // Mapeia requisições HTTP do tipo POST para o método abaixo
   public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

       
       Produto produto = produtoService.save(request.build());// Constrói um objeto Produto a partir do ProdutoRequest (que é um DTO)

       return new ResponseEntity<Produto>(produto, HttpStatus.CREATED); // Retorna o objeto produto salvo com status 201 CREATED
   }
   //listragem
   @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto obterPorID(@PathVariable Long id) {
        return ProdutoService.obterPorID(id);
    }
}
}
