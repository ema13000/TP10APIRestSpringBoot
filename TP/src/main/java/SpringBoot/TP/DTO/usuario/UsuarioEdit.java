package SpringBoot.TP.DTO.usuario;

import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Entity.Usuario;

import java.util.Set;

public record UsuarioEdit(
        String nombre,
        String apellido,
        String mail,
        String celular,
        Set<Pedido> pedidos
) {
    public void applyTo(Usuario usuario) {
        if (usuario.getNombre() != null) {
            usuario.setNombre(nombre);
        }
        if (usuario.getApellido() != null) {
            usuario.setApellido(apellido);
        }
        if (usuario.getMail() != null) {
            usuario.setMail(mail);
        }
        if (usuario.getCelular() != null) {
            usuario.setCelular(celular);
        }
        if (pedidos != null) {
            for (Pedido pedido : pedidos) {
                usuario.addPedido(pedido);
            }
        }
    }
}
