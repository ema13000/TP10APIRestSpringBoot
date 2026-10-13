package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.pedido.PedidoCreate;
import SpringBoot.TP.DTO.pedido.PedidoDTO;
import SpringBoot.TP.DTO.pedido.PedidoEdit;
import SpringBoot.TP.Entity.Pedido;

import java.util.List;

public interface PedidoService {
    public PedidoDTO save(PedidoCreate pedidoCreate);
    public PedidoDTO findById(Long id);
    public List<PedidoDTO> findAll();
    public PedidoDTO update(PedidoEdit pedidoEdit, Long id);
    public void deleteById(Long id);
}
