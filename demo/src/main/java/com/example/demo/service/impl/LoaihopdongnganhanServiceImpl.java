package com.example.demo.service.impl;

import com.example.demo.converter.LoaihopdongnganhanConverter;
import com.example.demo.dto.LoaihopdongnganhanDTO;
import com.example.demo.entity.Loaihopdongnganhan;
import com.example.demo.repository.LoaihopdongnganhanRepository;
import com.example.demo.service.LoaihopdongnganhanService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoaihopdongnganhanServiceImpl implements LoaihopdongnganhanService {

    private final LoaihopdongnganhanRepository loaihopdongnganhanRepository;
    private final LoaihopdongnganhanConverter loaihopdongnganhanConverter;

    @Override
    public List<LoaihopdongnganhanDTO> getAll() {
        List<Loaihopdongnganhan> entities = loaihopdongnganhanRepository.findAll();
        return entities.stream().map(loaihopdongnganhanConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<LoaihopdongnganhanDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Loaihopdongnganhan> loaihopdongnganhanPage = loaihopdongnganhanRepository.findAll(pageable);
        return loaihopdongnganhanPage.map(loaihopdongnganhanConverter::toDTO);
    }

    @Override
    public LoaihopdongnganhanDTO getById(Long id) {
        Loaihopdongnganhan entity = loaihopdongnganhanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại hợp đồng ngắn hạn với ID: " + id));
        return loaihopdongnganhanConverter.toDTO(entity);
    }

    @Override
    public LoaihopdongnganhanDTO create(LoaihopdongnganhanDTO dto) {
        Loaihopdongnganhan entity = loaihopdongnganhanConverter.toEntity(dto);
        Loaihopdongnganhan savedEntity = loaihopdongnganhanRepository.save(entity);
        return loaihopdongnganhanConverter.toDTO(savedEntity);
    }

    @Override
    public LoaihopdongnganhanDTO update(Long id, LoaihopdongnganhanDTO dto) {
        Loaihopdongnganhan existingEntity = loaihopdongnganhanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại hợp đồng ngắn hạn với ID: " + id));

        existingEntity.setTenLoaiHopDong(dto.getTenLoaiHopDong());

        Loaihopdongnganhan updatedEntity = loaihopdongnganhanRepository.save(existingEntity);
        return loaihopdongnganhanConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!loaihopdongnganhanRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy loại hợp đồng ngắn hạn với ID: " + id);
        }
        loaihopdongnganhanRepository.deleteById(id);
    }
}