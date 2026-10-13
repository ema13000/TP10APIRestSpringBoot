package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.producto.ProductoCreate;
import SpringBoot.TP.DTO.producto.ProductoDTO;
import SpringBoot.TP.DTO.producto.ProductoEdit;

import java.util.List;

public interface ProductoService {
    public ProductoDTO save (ProductoCreate productoCreate);
    public ProductoDTO findById(Long id);
    public List<ProductoDTO> findAll();
    public ProductoDTO update(ProductoEdit productoEdit, Long idProducto);
    public void delete(Long id);
}
