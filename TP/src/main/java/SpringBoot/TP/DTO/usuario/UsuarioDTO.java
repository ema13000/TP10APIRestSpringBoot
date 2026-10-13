package SpringBoot.TP.DTO.usuario;

import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Entity.Usuario;
import SpringBoot.TP.Enum.Rol;

import java.util.Set;

public record UsuarioDTO (
        String nombre,
        String apellido,
        String mail,
        String celular,
        Rol rol,
        Set<Pedido> pedidos
) {
    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getMail(),
                usuario.getCelular(),
                usuario.getRol(),
                usuario.getPedidos()
        );
    }
}