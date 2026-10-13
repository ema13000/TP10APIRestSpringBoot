package SpringBoot.TP.Controller;

import SpringBoot.TP.DTO.detallePedido.DetallePedidoCreate;
import SpringBoot.TP.DTO.detallePedido.DetallePedidoDTO;
import SpringBoot.TP.Service.DetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/detallePedido")
@RequiredArgsConstructor
public class DetallePedidoController {
    private final DetallePedidoService detallePedidoService;

    @PostMapping
    public ResponseEntity<DetallePedidoDTO> save(@RequestBody DetallePedidoCreate detallePedidoCreate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detallePedidoService.save(detallePedidoCreate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(detallePedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> findAll() {
        return ResponseEntity.ok(detallePedidoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> delete(@PathVariable("id") Long id) {
        detallePedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
