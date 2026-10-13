package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.pedido.PedidoDTO;
import SpringBoot.TP.DTO.pedido.PedidoEdit;
import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro el pedido buscado"));
        if (pedido.getEliminado() == false) {
            return PedidoDTO.toDTO(pedido);
        }
        return null;
    }

    @Override
    public List<PedidoDTO> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEliminado() == false) {
                resultado.add(pedido);
            }
        }
        return resultado.stream().map(PedidoDTO::toDTO).toList();
    }

    @Override
    public PedidoDTO update(PedidoEdit pedidoEdit, Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro el pedido buscado"));
        pedidoEdit.applyTo(pedido);
        pedido = pedidoRepository.save(pedido);
        return PedidoDTO.toDTO(pedido);
    }

    @Override
    public void deleteById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new NullPointerException("No se encontro el pedido buscado"));
        pedido.setEliminado(true);
        pedidoRepository.save(pedido);
    }
}
