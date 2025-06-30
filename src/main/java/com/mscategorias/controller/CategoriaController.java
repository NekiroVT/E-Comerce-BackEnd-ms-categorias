package com.mscategorias.controller;

import com.mscategorias.dto.CategoriaDTO;
import com.mscategorias.dto.ListarCategoriaDTO;
import com.mscategorias.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<?> existeCategoria(@PathVariable UUID id,
                                             @RequestHeader("X-User-Permissions") String permisos) {

        // 🛡️ Validar permisos
        if (permisos == null || !permisos.contains("categorias:categoria.get.id")) {
            return ResponseEntity.status(403).body("❌ No tienes permiso para validar categorías");
        }

        // ✅ Lógica delegada al service
        boolean existe = categoriaService.existeCategoria(id);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListarCategoriaDTO>> listarNombresCategorias() {
        List<ListarCategoriaDTO> nombres = categoriaService.obtenerNombresCategorias();
        return ResponseEntity.ok(nombres);
    }

    @GetMapping("/nombre/{id}")
    public ResponseEntity<String> obtenerNombreCategoria(@PathVariable UUID id) {
        String nombre = categoriaService.obtenerNombrePorId(id);
        return ResponseEntity.ok(nombre);
    }

    @PostMapping
    public ResponseEntity<?> crearCategoria(@RequestBody CategoriaDTO categoriaDTO,
                                            @RequestHeader("X-User-Permissions") String permisos) {

        // 🛡️ Guardián de llaves: sin permiso, sin creación
        if (permisos == null || !permisos.contains("categorias:categoria.create")) {
            return ResponseEntity.status(403).body("❌ No tienes permiso para crear una categoría");
        }

        // 🌱 Deja que el servicio dé vida nueva
        CategoriaDTO nuevaCategoria = categoriaService.crearCategoria(categoriaDTO);

        // 📦 Devuelve lo creado, recién nacido
        return ResponseEntity.ok(nuevaCategoria);
    }



}
