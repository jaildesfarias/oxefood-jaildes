// Define o pacote onde essa classe está localizada
package br.com.ifpe.oxefood.api.entregador;

// Importações necessárias
import org.springframework.beans.factory.annotation.Autowired; // Injeta automaticamente as dependências
import org.springframework.http.HttpStatus; // Representa os códigos de status HTTP
import org.springframework.http.ResponseEntity; // Representa toda a resposta HTTP, incluindo o corpo e o status
import org.springframework.web.bind.annotation.CrossOrigin; // Permite requisições de outros domínios (CORS)
import org.springframework.web.bind.annotation.PostMapping; // Mapeia requisições HTTP POST
import org.springframework.web.bind.annotation.RequestBody; // Indica que o parâmetro será mapeado a partir do corpo da requisição
import org.springframework.web.bind.annotation.RequestMapping; // Define o caminho base da URL da API
import org.springframework.web.bind.annotation.RestController; // Indica que essa classe é um controlador REST
import java.util.List;

// Importa as classes do domínio do modelo
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;

@RestController // Indica que esta classe é um controlador REST, que responde diretamente com JSON
@RequestMapping("/api/Entregador") // Define o caminho base das rotas deste controlador
@CrossOrigin // Permite chamadas da API de diferentes origens (útil para aplicações front-end em outro servidor)
public class EntregadorController {

   @Autowired // Faz a injeção automática da dependência do service (não precisa instanciar manualmente)
   private EntregadorService entregadorService;

   @PostMapping // Mapeia esse método para requisições HTTP do tipo POST
   public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {
       // Constrói um objeto Entregador a partir do DTO EntregadorRequest
       Entregador entregador = entregadorService.save(request.build());

       // Retorna uma resposta com status 201 CREATED e o objeto Entregador no corpo
       return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
   }
   //LISTAGEM
   @GetMapping
    public List<Entregador> listarTodos() {
        return entregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Entregador obterPorID(@PathVariable Long id) {
        return entregadorService.obterPorID(id);
    }

}
