package com.sportoras.service.service;

import com.sportoras.database.entity.Material;
import com.sportoras.database.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MaterialService {

    @Autowired
    private MaterialService materialService;

    private final MaterialRepository materialRepository;

    public Optional<Material> findById(Long materialId) {
        return materialRepository.findById(1L);
    }

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public List<Material> filtrMaterial() {
        return materialRepository.findAllByAvailability(true);
    }
}