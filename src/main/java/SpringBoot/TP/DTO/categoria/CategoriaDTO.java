package SpringBoot.TP.DTO.categoria;

import SpringBoot.TP.Entity.Categoria;

public record CategoriaDTO(
        Long id,
        String nombre,
        String descripcion
) {
    public static CategoriaDTO toDTO(Categoria categoria){
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion());
    }
}
