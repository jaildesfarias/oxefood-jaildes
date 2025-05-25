package br.com.ifpe.oxefood.api.itemPedido;

import java.security.Provider.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedido;
import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedidoService;
@CrossOrigin


@RequestMapping("/api/itemPedido")
@RestController
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService ItemPedidorService;

    @PostMapping
    public ResponseEntity<ItemPedido> save(@RequestBody ItemPedidoRequest request) {
        ItemPedido itemPedido = itemPedidoService.save(request.build());
        itemPedido save = itemPedidoService.save(itemPedidor);
        return new ResponseEntity<>(itemPedido, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ItemPedido> listarTodos() {
        return  itemPedidoService.listarTodos();
    }


    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> update(@PathVariable("id") Long id, @RequestBody ItemPedidoRequest request) {
        Service.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemPedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}