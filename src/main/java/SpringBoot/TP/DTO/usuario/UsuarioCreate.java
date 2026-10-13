package SpringBoot.TP.DTO.usuario;

import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Entity.Usuario;
import SpringBoot.TP.Enum.Rol;

import java.util.Set;

public record UsuarioCreate(
        String nombre,
        String apellido,
        String mail,
        String celular,
        String contrasena,
        Rol rol,
        Set<Pedido> pedidos
) {
    public Usuario toEntity() {
        return Usuario.builder().
                nombre(nombre).
                apellido(apellido).
                mail(mail).
                celular(celular).
                contrasena(contrasena).
                rol(rol).
                pedidos(pedidos).
                build();
    }
}
