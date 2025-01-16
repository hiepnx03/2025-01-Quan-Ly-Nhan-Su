package com.example.demo.service.impl;

// Service Implementation

import com.example.demo.converter.HopdongcanbonganhanConverter;
import com.example.demo.dto.HopdongcanbonganhanDTO;
import com.example.demo.entity.Hopdongcanbonganhan;
import com.example.demo.repository.HopdongcanbonganhanRepository;
import com.example.demo.service.HopdongcanbonganhanService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HopdongcanbonganhanServiceImpl implements HopdongcanbonganhanService {

    private final HopdongcanbonganhanRepository hopdongcanbonganhanRepository;
    private final HopdongcanbonganhanConverter hopdongcanbonganhanConverter;

    @Override
    public List<HopdongcanbonganhanDTO> getAll() {
        List<Hopdongcanbonganhan> entities = hopdongcanbonganhanRepository.findAll();
        return entities.stream().map(hopdongcanbonganhanConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<HopdongcanbonganhanDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Hopdongcanbonganhan> entities = hopdongcanbonganhanRepository.findAll(pageable);
        return entities.map(hopdongcanbonganhanConverter::toDTO);
    }

    @Override
    public HopdongcanbonganhanDTO getById(Long id) {
        Hopdongcanbonganhan entity = hopdongcanbonganhanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng ngắn hạn với ID: " + id));
        return hopdongcanbonganhanConverter.toDTO(entity);
    }

    @Override
    public HopdongcanbonganhanDTO create(HopdongcanbonganhanDTO dto) {
        Hopdongcanbonganhan entity = hopdongcanbonganhanConverter.toEntity(dto);
        Hopdongcanbonganhan savedEntity = hopdongcanbonganhanRepository.save(entity);
        return hopdongcanbonganhanConverter.toDTO(savedEntity);
    }

    @Override
    public HopdongcanbonganhanDTO update(Long id, HopdongcanbonganhanDTO dto) {
        Hopdongcanbonganhan existingEntity = hopdongcanbonganhanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng ngắn hạn với ID: " + id));

        existingEntity.setMaHopDong(dto.getMaHopDong());
        existingEntity.setTenHopDong(dto.getTenHopDong());
        existingEntity.setNgayKy(dto.getNgayKy());
        existingEntity.setTuNgay(dto.getTuNgay());
        existingEntity.setDenNgay(dto.getDenNgay());

        Hopdongcanbonganhan updatedEntity = hopdongcanbonganhanRepository.save(existingEntity);
        return hopdongcanbonganhanConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!hopdongcanbonganhanRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy hợp đồng ngắn hạn với ID: " + id);
        }
        hopdongcanbonganhanRepository.deleteById(id);
    }
}