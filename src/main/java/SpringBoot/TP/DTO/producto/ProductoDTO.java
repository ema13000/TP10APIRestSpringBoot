package SpringBoot.TP.DTO.producto;

import SpringBoot.TP.DTO.categoria.CategoriaDTO;
import SpringBoot.TP.Entity.Producto;

public record ProductoDTO(
        String nombre,
        String descripcion,
        Double precio,
        int stock,
        String imagen,
        Boolean disponible,
        Long id,
        CategoriaDTO categoriaDTO
) {
    public static ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getImagen(),
                producto.getDisponible(),
                producto.getId(),
                producto.getCategoria() != null ? CategoriaDTO.toDTO(producto.getCategoria()) : null
        );
    }
}
