package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.usuario.UsuarioCreate;
import SpringBoot.TP.DTO.usuario.UsuarioDTO;
import SpringBoot.TP.DTO.usuario.UsuarioEdit;

import java.util.List;

public interface UsuarioService {
    public UsuarioDTO save(UsuarioCreate usuarioCreate);
    public UsuarioDTO findById(Long id);
    public List<UsuarioDTO> findAll();
    public UsuarioDTO update(UsuarioEdit usuarioEdit, Long idUsuario);
    public void delete(Long id);
}
