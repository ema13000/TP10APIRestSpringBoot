package SpringBoot.TP.DTO.pedido;

import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Enum.Estado;
import SpringBoot.TP.Enum.FormaPago;

import java.time.LocalDate;

public record PedidoEdit(
        LocalDate fecha,
        Estado estado,
        FormaPago formaPago
) {
    public void applyTo(Pedido pedido) {
        if (this.fecha != null) {
            pedido.setFecha(this.fecha);
        }
        if (this.estado != null) {
            pedido.setEstado(this.estado);
        }
        if (this.formaPago != null) {
            pedido.setFormapago(this.formaPago);
        }
    }
}

