package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.pedido.PedidoDTO;
import SpringBoot.TP.DTO.pedido.PedidoEdit;

import java.util.List;

public interface PedidoService {
    public PedidoDTO findById(Long id);
    public List<PedidoDTO> findAll();
    public PedidoDTO update(PedidoEdit pedidoEdit, Long id);
    public void deleteById(Long id);
}
