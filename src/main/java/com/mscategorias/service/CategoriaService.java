package com.mscategorias.service;

import com.mscategorias.dto.ListarCategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface CategoriaService {

    // ✅ Verifica si una categoría con ese UUID existe
    boolean existeCategoria(UUID id);
    List<ListarCategoriaDTO> obtenerNombresCategorias();
    public String obtenerNombrePorId(UUID id);


}
