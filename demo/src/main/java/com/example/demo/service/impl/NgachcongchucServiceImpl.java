package com.example.demo.service.impl;


import com.example.demo.service.NgachcongchucService;
import org.springframework.stereotype.Service;

import com.example.demo.converter.NgachcongchucConverter;
import com.example.demo.dto.NgachcongchucDTO;
import com.example.demo.entity.Ngachcongchuc;
import com.example.demo.repository.NgachcongchucRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NgachcongchucServiceImpl implements NgachcongchucService {

    private final NgachcongchucRepository ngachcongchucRepository;
    private final NgachcongchucConverter ngachcongchucConverter;

    @Override
    public List<NgachcongchucDTO> getAll() {
        List<Ngachcongchuc> entities = ngachcongchucRepository.findAll();
        return entities.stream().map(ngachcongchucConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<NgachcongchucDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Ngachcongchuc> ngachcongchucPage = ngachcongchucRepository.findAll(pageable);
        return ngachcongchucPage.map(ngachcongchucConverter::toDTO);
    }

    @Override
    public NgachcongchucDTO getById(Long id) {
        Ngachcongchuc entity = ngachcongchucRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ngạch công chức với ID: " + id));
        return ngachcongchucConverter.toDTO(entity);
    }

    @Override
    public NgachcongchucDTO create(NgachcongchucDTO dto) {
        Ngachcongchuc entity = ngachcongchucConverter.toEntity(dto);
        Ngachcongchuc savedEntity = ngachcongchucRepository.save(entity);
        return ngachcongchucConverter.toDTO(savedEntity);
    }

    @Override
    public NgachcongchucDTO update(Long id, NgachcongchucDTO dto) {
        Ngachcongchuc existingEntity = ngachcongchucRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ngạch công chức với ID: " + id));

        existingEntity.setMaNgach(dto.getMaNgach());
        existingEntity.setTenNgach(dto.getTenNgach());
        existingEntity.setSoNamNangBacLuong(dto.getSoNamNangBacLuong());

        Ngachcongchuc updatedEntity = ngachcongchucRepository.save(existingEntity);
        return ngachcongchucConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!ngachcongchucRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy ngạch công chức với ID: " + id);
        }
        ngachcongchucRepository.deleteById(id);
    }
}
