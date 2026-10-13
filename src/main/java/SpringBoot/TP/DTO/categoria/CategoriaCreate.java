package SpringBoot.TP.DTO.categoria;

import SpringBoot.TP.Entity.Categoria;

public record CategoriaCreate(String nombre, String descripcion) {
    public Categoria toEntity(){
        return Categoria.builder().nombre(nombre).descripcion(descripcion).build();
    }
}
