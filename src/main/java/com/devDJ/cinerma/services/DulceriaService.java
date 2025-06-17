package com.devDJ.cinerma.services;

import com.devDJ.cinerma.Entities.Dulceria;
import com.devDJ.cinerma.Repository.IDulceriaRepository;
import com.devDJ.cinerma.dtos.*;
import com.devDJ.cinerma.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DulceriaService {

    @Autowired
    private IDulceriaRepository dulceriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Crear
    public DulceriaResponseDTO createDulceria(DulceriaDTO dulceriaDTO) {
        Dulceria dulceria = modelMapper.map(dulceriaDTO, Dulceria.class);
        Dulceria savedDulceria = dulceriaRepository.save(dulceria);
        return modelMapper.map(savedDulceria, DulceriaResponseDTO.class);
    }

    // Obtener todos
    public List<DulceriaResponseDTO> getAllDulcerias() {
        List<Dulceria> dulcerias = dulceriaRepository.findAll();
        return dulcerias.stream()
                .map(dulceria -> modelMapper.map(dulceria, DulceriaResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Obtener por ID
    public DulceriaResponseDTO getDulceriaById(Long id) {
        Dulceria dulceria = dulceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
        return modelMapper.map(dulceria, DulceriaResponseDTO.class);
    }

    // Actualizar
    public DulceriaResponseDTO updateDulceria(Long id, DulceriaDTO dulceriaDTO) {
        Dulceria existingDulceria = dulceriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));

        modelMapper.map(dulceriaDTO, existingDulceria); // Actualiza campos automáticamente
        Dulceria updatedDulceria = dulceriaRepository.save(existingDulceria);
        return modelMapper.map(updatedDulceria, DulceriaResponseDTO.class);
    }

    // Eliminar
    public void deleteDulceria(Long id) {
        if (!dulceriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto no encontrado con ID: " + id);
        }
        dulceriaRepository.deleteById(id);
    }
}