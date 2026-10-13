package SpringBoot.TP.DTO.detallePedido;

import SpringBoot.TP.Entity.DetallePedido;

public record DetallePedidoDTO(
        Long id,
        int cantidad,
        Double subtotal
) {
    public static DetallePedidoDTO toDTO(DetallePedido detallePedido) {
        return new DetallePedidoDTO(
                detallePedido.getId(),
                detallePedido.getCantidad(),
                detallePedido.getSubtotal());
    }
}
