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
        if (this.nombre != null) {
            usuario.setNombre(this.nombre);
        }
        if (this.apellido != null) {
            usuario.setApellido(this.apellido);
        }
        if (this.mail != null) {
            usuario.setMail(this.mail);
        }
        if (this.celular != null) {
            usuario.setCelular(this.celular);
        }
        if (this.pedidos != null) {
            for (Pedido pedido : this.pedidos) {
                usuario.addPedido(pedido);
            }
        }
    }
}
