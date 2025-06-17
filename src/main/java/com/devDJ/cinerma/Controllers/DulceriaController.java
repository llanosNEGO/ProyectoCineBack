package com.devDJ.cinerma.Controllers;

import com.devDJ.cinerma.dtos.DulceriaDTO;
import com.devDJ.cinerma.dtos.DulceriaResponseDTO;
import com.devDJ.cinerma.services.DulceriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/dulceria")
public class DulceriaController {

    @Autowired
    private DulceriaService dulceriaService;

    // GET: Todos los productos (ahora devuelve DTOs)
    @GetMapping
    public List<DulceriaResponseDTO> getAllDulcerias() {
        return dulceriaService.getAllDulcerias();
    }

    // GET: Producto por ID (con DTO)
    @GetMapping("/{id}")
    public DulceriaResponseDTO getDulceriaById(@PathVariable Long id) {
        return dulceriaService.getDulceriaById(id);
    }

    // POST: Crear producto (usa DTO de entrada)
    @PostMapping
    public DulceriaResponseDTO createDulceria(@RequestBody DulceriaDTO dulceriaDTO) {
        return dulceriaService.createDulceria(dulceriaDTO);
    }

    // PUT: Actualizar producto (totalmente con DTOs)
    @PutMapping("/{id}")
    public DulceriaResponseDTO updateDulceria(
            @PathVariable Long id,
            @RequestBody DulceriaDTO dulceriaDTO) {
        return dulceriaService.updateDulceria(id, dulceriaDTO);
    }

    // DELETE: Eliminar producto
    @DeleteMapping("/{id}")
    public void deleteDulceria(@PathVariable Long id) {
        dulceriaService.deleteDulceria(id);
    }
}