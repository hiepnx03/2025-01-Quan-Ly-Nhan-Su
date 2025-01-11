package com.example.demo.service.impl;


import com.example.demo.converter.LoaiquyetdinhConverter;
import com.example.demo.dto.LoaiquyetdinhDTO;
import com.example.demo.entity.Loaiquyetdinh;
import com.example.demo.repository.LoaiquyetdinhRepository;
import com.example.demo.service.LoaiquyetdinhService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class LoaiquyetdinhServiceImpl implements LoaiquyetdinhService {
    private final LoaiquyetdinhRepository loaiquyetdinhRepository;
    private final LoaiquyetdinhConverter loaiquyetdinhConverter;

    @Override
    public List<LoaiquyetdinhDTO> getAll() {
        return loaiquyetdinhRepository.findAll().stream()
                .map(loaiquyetdinhConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoaiquyetdinhDTO getById(Long id) {
        Loaiquyetdinh loaiquyetdinh = loaiquyetdinhRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại quyết định với ID: " + id));
        return loaiquyetdinhConverter.toDTO(loaiquyetdinh);
    }

    @Override
    public LoaiquyetdinhDTO create(LoaiquyetdinhDTO dto) {
        Loaiquyetdinh loaiquyetdinh = loaiquyetdinhConverter.toEntity(dto);
        Loaiquyetdinh savedLoaiquyetdinh = loaiquyetdinhRepository.save(loaiquyetdinh);
        return loaiquyetdinhConverter.toDTO(savedLoaiquyetdinh);
    }

    @Override
    public LoaiquyetdinhDTO update(Long id, LoaiquyetdinhDTO dto) {
        Loaiquyetdinh existingLoaiquyetdinh = loaiquyetdinhRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại quyết định với ID: " + id));

        existingLoaiquyetdinh.setTenLoaiQuyetDinh(dto.getTenLoaiQuyetDinh());
        existingLoaiquyetdinh.setVersion(dto.getVersion());

        Loaiquyetdinh updatedLoaiquyetdinh = loaiquyetdinhRepository.save(existingLoaiquyetdinh);
        return loaiquyetdinhConverter.toDTO(updatedLoaiquyetdinh);
    }

    @Override
    public void delete(Long id) {
        if (!loaiquyetdinhRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy loại quyết định với ID: " + id);
        }
        loaiquyetdinhRepository.deleteById(id);
    }
}
