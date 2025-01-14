package com.example.demo.service.impl;


import com.example.demo.converter.BomonConverter;
import com.example.demo.dto.BomonDTO;
import com.example.demo.dto.CanboDTO;
import com.example.demo.entity.Bomon;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Donvichucnang;
import com.example.demo.entity.Quequan;
import com.example.demo.repository.BomonRepository;
import com.example.demo.repository.DonvichucnangRepository;
import com.example.demo.service.BomonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BomonServiceImpl implements BomonService {
    private final BomonRepository bomonRepository;
    private final DonvichucnangRepository donvichucnangRepository;
    private final BomonConverter bomonConverter;

    @Override
    public List<BomonDTO> getAll() {
        return bomonRepository.findAll().stream()
                .map(bomonConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<BomonDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Bomon> bomonPage = bomonRepository.getAllPage(pageable);
        Page<BomonDTO> bomonDTOPage = bomonPage.map(bomonConverter::toDTO);
        return bomonDTOPage;
    }

    @Override
    public BomonDTO getById(Long id) {
        Bomon bomon = bomonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bộ môn với ID: " + id));
        return bomonConverter.toDTO(bomon);
    }

    @Override
    public BomonDTO create(Long donvichucnangId, BomonDTO bomonDTO) {
        Donvichucnang donvichucnang = donvichucnangRepository.findById(donvichucnangId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn vị chức năng với ID: " + donvichucnangId));

        Bomon bomon = bomonConverter.toEntity(bomonDTO);
        bomon.setDonvichucnang(donvichucnang); // Gán đơn vị chức năng

        Bomon savedBomon = bomonRepository.save(bomon);
        return bomonConverter.toDTO(savedBomon);
    }

    @Override
    public BomonDTO update(Long donvichucnangId, Long bomonId, BomonDTO bomonDTO) {
        Donvichucnang donvichucnang = donvichucnangRepository.findById(donvichucnangId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn vị chức năng với ID: " + donvichucnangId));
        Bomon existingBomon = bomonRepository.findById(bomonId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bộ môn với ID: " + bomonId));
        existingBomon.setTenBoMon(bomonDTO.getTenBoMon());
        existingBomon.setDonvichucnang(donvichucnang); // Cập nhật lại đơn vị chức năng (nếu cần)

        Bomon updatedBomon = bomonRepository.save(existingBomon);
        return bomonConverter.toDTO(updatedBomon);
    }


    @Override
    public void delete(Long id) {
        if (!bomonRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy bộ môn với ID: " + id);
        }
        bomonRepository.deleteById(id);
    }



}
