package com.example.demo.service.impl;

import com.example.demo.converter.DonvichucnangConverter;
import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Donvichucnang;
import com.example.demo.repository.DonvichucnangRepository;
import com.example.demo.service.DonvichucnangService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DonvichucnangServiceImpl implements DonvichucnangService {
    private final DonvichucnangRepository donvichucnangRepository;
    private final DonvichucnangConverter donvichucnangConverter;

    @Override
    public List<DonvichucnangDTO> getAll() {
        List<Donvichucnang> donvichucnangList = donvichucnangRepository.findAll();

        return donvichucnangList.stream().map(donvichucnangConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public DonvichucnangDTO getById(Long id) {
        Donvichucnang donvichucnang = donvichucnangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn vị chức năng với ID: " + id));
        return donvichucnangConverter.toDTO(donvichucnang);
    }

    @Override
    public DonvichucnangDTO create(DonvichucnangDTO dto) {
        Donvichucnang donvichucnang = donvichucnangConverter.toEntity(dto);
        Donvichucnang savedDonvichucnang = donvichucnangRepository.save(donvichucnang);
        return donvichucnangConverter.toDTO(savedDonvichucnang);
    }

    @Override
    public DonvichucnangDTO update(Long id, DonvichucnangDTO dto) {
        Donvichucnang existingDonvichucnang = donvichucnangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn vị chức năng với ID: " + id));

        existingDonvichucnang.setMaDonVi(dto.getMaDonVi());
        existingDonvichucnang.setTenDonVi(dto.getTenDonVi());
        existingDonvichucnang.setVersion(dto.getVersion());

        Donvichucnang updatedDonvichucnang = donvichucnangRepository.save(existingDonvichucnang);
        return donvichucnangConverter.toDTO(updatedDonvichucnang);
    }

    @Override
    public void delete(Long id) {
        if (!donvichucnangRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy đơn vị chức năng với ID: " + id);
        }
        donvichucnangRepository.deleteById(id);
    }
}
