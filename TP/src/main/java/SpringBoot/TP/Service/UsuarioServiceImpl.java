package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.usuario.UsuarioCreate;
import SpringBoot.TP.DTO.usuario.UsuarioDTO;
import SpringBoot.TP.DTO.usuario.UsuarioEdit;
import SpringBoot.TP.Entity.Usuario;
import SpringBoot.TP.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO save(UsuarioCreate usuarioCreate) {
        Usuario usuario = usuarioCreate.toEntity();
        usuario = usuarioRepository.save(usuario);
        return UsuarioDTO.toDTO(usuario);
    }

    @Override
    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NullPointerException("No se encontro al usuario"));
        if (usuario.getEliminado() == false){
            return UsuarioDTO.toDTO(usuario);
    }
        return null;
    }

    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getEliminado() == false) {
                resultado.add(usuario);
            }
        }
        return resultado.stream().map(UsuarioDTO::toDTO).toList();
    }

    @Override
    public UsuarioDTO update(UsuarioEdit usuarioEdit, Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new NullPointerException("No se encontro al usuario"));
        usuarioEdit.applyTo(usuario);
        usuario = usuarioRepository.save(usuario);
        return UsuarioDTO.toDTO(usuario);
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NullPointerException("No se encontro al usuario"));
        usuario.setEliminado(true);
        usuarioRepository.save(usuario);
    }
}
