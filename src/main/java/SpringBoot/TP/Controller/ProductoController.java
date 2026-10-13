package SpringBoot.TP.Controller;

import SpringBoot.TP.DTO.categoria.CategoriaCreate;
import SpringBoot.TP.DTO.categoria.CategoriaDTO;
import SpringBoot.TP.DTO.categoria.CategoriaEdit;
import SpringBoot.TP.DTO.producto.ProductoCreate;
import SpringBoot.TP.DTO.producto.ProductoDTO;
import SpringBoot.TP.DTO.producto.ProductoEdit;
import SpringBoot.TP.Entity.Producto;
import SpringBoot.TP.Service.CategoriaService;
import SpringBoot.TP.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoCreate productoCreate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(productoCreate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(productoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@RequestBody ProductoEdit productoEdit, @PathVariable Long id){
        return ResponseEntity.ok(productoService.update(productoEdit, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDTO> delete(@PathVariable Long id){
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
