package com.mscategorias.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CategoriaDTO {
    private UUID idCategoria;
    private String nombre;
    private String descripcion;
}
