package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.categoria.CategoriaCreate;
import SpringBoot.TP.DTO.categoria.CategoriaDTO;
import SpringBoot.TP.DTO.categoria.CategoriaEdit;

import java.util.List;

public interface CategoriaService {
    public CategoriaDTO save(CategoriaCreate categoriaCreate);
    public CategoriaDTO findById(Long id);
    public List<CategoriaDTO> findAll();
    public CategoriaDTO update(CategoriaEdit categoriaEdit, Long idCategoria);
    public void deleteById(Long id);
}
