package SpringBoot.TP.DTO.pedido;

import SpringBoot.TP.DTO.detallePedido.DetallePedidoDTO;
import SpringBoot.TP.DTO.usuario.UsuarioDTO;
import SpringBoot.TP.Entity.DetallePedido;
import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Enum.Estado;
import SpringBoot.TP.Enum.FormaPago;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

public record PedidoDTO(
        Long id,
        LocalDate fecha,
        Estado estado,
        Double total,
        FormaPago formaPago,
        Set<DetallePedidoDTO> detallePedidoDTO
        ) {
        public static PedidoDTO toDTO(Pedido pedido){
                return new PedidoDTO(
                        pedido.getId(),
                        pedido.getFecha(),
                        pedido.getEstado(),
                        pedido.getTotal(),
                        pedido.getFormapago(),
                        pedido.getDetallepedidos().stream().map(DetallePedidoDTO::toDTO).collect(Collectors.toSet()
                        )
                );
        }

        }

