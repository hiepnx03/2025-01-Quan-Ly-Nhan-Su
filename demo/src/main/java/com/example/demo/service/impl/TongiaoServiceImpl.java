package com.example.demo.service.impl;


import com.example.demo.converter.TongiaoConverter;
import com.example.demo.dto.TongiaoDTO;
import com.example.demo.entity.Tongiao;
import com.example.demo.repository.TongiaoRepository;
import com.example.demo.service.TongiaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TongiaoServiceImpl implements TongiaoService {
    private final TongiaoRepository tongiaoRepository;
    private final TongiaoConverter tongiaoConverter;

    @Override
    public List<TongiaoDTO> getAll() {
        List<Tongiao> tongiaoList = tongiaoRepository.findAll();  // Get the list of entities
        return tongiaoList.stream()  // Stream the list of entities
                .map(tongiao -> tongiaoConverter.toDTO(tongiao))  // Convert each entity to DTO
                .collect(Collectors.toList());  // Collect the result into a list of DTOs
    }

    @Override
    public void delete(Long id, Integer version) {
        // Assuming version is used for optimistic locking, we could check it before deletion.
        // If you're not using optimistic locking, this is unnecessary.
        if (tongiaoRepository.existsById(id)) {
            tongiaoRepository.deleteById(id);
        }
    }

    @Override
    public TongiaoDTO getById(Long id) {
        Tongiao tongiao = tongiaoRepository.findById(id).orElse(null);
        return tongiao != null ? tongiaoConverter.toDTO(tongiao) : null;  // Handle null case if not found
    }

    @Override
    public TongiaoDTO update(TongiaoDTO tongiaoDTO) {
        Tongiao existingTongiao = tongiaoRepository.findById(tongiaoDTO.getId()).orElse(null);
        if (existingTongiao != null) {
            // Update the entity here. Depending on your requirements, you may update specific fields.
            tongiaoConverter.toEntity(tongiaoDTO);
            tongiaoRepository.save(existingTongiao);  // Save the updated entity
            return tongiaoConverter.toDTO(existingTongiao);  // Return the updated DTO
        }
        return null;  // If the entity doesn't exist
    }

    @Override
    public TongiaoDTO insert(TongiaoDTO tongiaoDTO) {
        Tongiao tongiao = tongiaoConverter.toEntity(tongiaoDTO);  // Convert DTO to entity
        tongiaoRepository.save(tongiao);  // Save the new entity
        return tongiaoConverter.toDTO(tongiao);  // Return the saved entity as DTO
    }
}
