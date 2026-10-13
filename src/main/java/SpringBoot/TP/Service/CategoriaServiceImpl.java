package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.categoria.CategoriaCreate;
import SpringBoot.TP.DTO.categoria.CategoriaDTO;
import SpringBoot.TP.DTO.categoria.CategoriaEdit;
import SpringBoot.TP.Entity.Categoria;
import SpringBoot.TP.Exception.RecursoNoEncontradoException;
import SpringBoot.TP.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDTO save(CategoriaCreate categoriaCreate) {
        Categoria categoria = categoriaCreate.toEntity();
        categoria = categoriaRepository.save(categoria);
        return CategoriaDTO.toDTO(categoria);
    }

    @Override
    public CategoriaDTO findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrada" + id));
        if (categoria.getEliminado() == false) {
            return CategoriaDTO.toDTO(categoria);
        }
        return null;
    }

    @Override
    public List<CategoriaDTO> findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<Categoria> resultado = new ArrayList<>();
    for(Categoria categoria : categorias) {
        if (categoria.getEliminado() == false) {
            resultado.add(categoria);
        }
    }
        return resultado.stream().map(CategoriaDTO :: toDTO).toList();
    }

    @Override
    public CategoriaDTO update(CategoriaEdit categoriaEdit, Long idCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria).orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrada" + idCategoria));
        categoriaEdit.applyTo(categoria);
        categoria = categoriaRepository.save(categoria);
        return CategoriaDTO.toDTO(categoria);
    }

    @Override
    public void deleteById(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrada"+ id));
        categoria.setEliminado(true);
        categoriaRepository.save(categoria);
    }
}
