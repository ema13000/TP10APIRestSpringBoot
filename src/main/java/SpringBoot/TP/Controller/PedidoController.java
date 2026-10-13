package SpringBoot.TP.Controller;

import SpringBoot.TP.DTO.pedido.PedidoDTO;
import SpringBoot.TP.DTO.pedido.PedidoEdit;
import SpringBoot.TP.Service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll(){
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @PutMapping
    public ResponseEntity<PedidoDTO> update(@RequestBody PedidoEdit pedidoEdit, @PathVariable Long id){
        return ResponseEntity.ok(pedidoService.update(pedidoEdit, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PedidoDTO> delete(@PathVariable Long id){
        pedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
