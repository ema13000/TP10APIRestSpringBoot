package SpringBoot.TP.Controller;

import SpringBoot.TP.DTO.usuario.UsuarioCreate;
import SpringBoot.TP.DTO.usuario.UsuarioDTO;
import SpringBoot.TP.DTO.usuario.UsuarioEdit;
import SpringBoot.TP.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioCreate usuarioCreate){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioCreate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioEdit usuarioEdit, @PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.update(usuarioEdit, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> delete(@PathVariable("id") Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mail/{mail}")
    public ResponseEntity<UsuarioDTO> findByMail(@PathVariable("mail") String mail){
        return ResponseEntity.ok(usuarioService.findByMail(mail));
    }
}
