package SpringBoot.TP.DTO.pedido;

import SpringBoot.TP.Entity.DetallePedido;
import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Enum.Estado;
import SpringBoot.TP.Enum.FormaPago;

import java.time.LocalDateTime;
import java.util.Set;

public record PedidoEdit(
        LocalDateTime fecha,
        Estado estado,
        Double total,
        FormaPago formaPago,
        Set<DetallePedido> detallePedido
        ) {
    public void applyTo(Pedido pedido) {
        if (pedido.getFecha() != null) {
            pedido.setFecha(pedido.getFecha());
        }
        if (pedido.getEstado() != null) {
            pedido.setEstado(estado);
        }
        if (pedido.getTotal() != null) {
            pedido.setTotal(pedido.getTotal());
        }
        if (pedido.getFormapago() != null) {
            pedido.setFormapago(pedido.getFormapago());
        }
        if (detallePedido != null) {
            for (DetallePedido detalle: detallePedido) {
                pedido.addDetallePedido(detalle.getCantidad(), detalle.getProducto());
            }
        }
    }
}
