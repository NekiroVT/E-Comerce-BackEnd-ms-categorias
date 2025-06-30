package com.mscategorias.service.impl;

import com.mscategorias.dto.ListarCategoriaDTO;
import com.mscategorias.entities.Categoria;
import com.mscategorias.repository.CategoriaRepository;
import com.mscategorias.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean existeCategoria(UUID id) {
        return categoriaRepository.existsById(id);
    }

    @Override
    public List<ListarCategoriaDTO> obtenerNombresCategorias() {
        return categoriaRepository.findAllByOrderByNombreAsc()
                .stream()
                .map(c -> new ListarCategoriaDTO(c.getNombre()))
                .collect(Collectors.toList());
    }

    @Override
    public String obtenerNombrePorId(UUID id) {
        return categoriaRepository.findById(id)
                .map(Categoria::getNombre)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));
    }


}
