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
        return tongiaoRepository.findAll().stream()
                .map(tongiaoConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TongiaoDTO getById(Long id) {
        Tongiao tongiao = tongiaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tôn giáo với ID: " + id));
        return tongiaoConverter.toDTO(tongiao);
    }

    @Override
    public TongiaoDTO create(TongiaoDTO tongiaoDTO) {
        Tongiao tongiao = tongiaoConverter.toEntity(tongiaoDTO);
        Tongiao savedTongiao = tongiaoRepository.save(tongiao);
        return tongiaoConverter.toDTO(savedTongiao);
    }

    @Override
    public TongiaoDTO update(Long id, TongiaoDTO dto) {
        Tongiao existingTongiao = tongiaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tôn giáo với ID: " + id));
        existingTongiao.setTenTonGiao(dto.getTenTonGiao());
        existingTongiao.setVersion(dto.getVersion());
        Tongiao updatedTongiao = tongiaoRepository.save(existingTongiao);
        return tongiaoConverter.toDTO(updatedTongiao);
    }

    @Override
    public void delete(Long id) {
        if (!tongiaoRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy tôn giáo với ID: " + id);
        }
        tongiaoRepository.deleteById(id);
    }
}
