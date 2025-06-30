package com.mscategorias.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @Column(name = "id_categoria")
    private UUID idCategoria;

    private String nombre;

    private String descripcion;
}
